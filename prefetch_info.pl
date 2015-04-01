#! c:\perl\bin\perl.exe
#----------------------------------------------------------
# Prefetch_info.pl
# Dump Prefetch information 
#
# Usage: C:\Perl>[perl] prefetch_info.pl <filename> [> output]
#
#License: GPL
#
# Written By:    Mark McKinnon
# Date Written:  01-16-2008
#
# Modification Section
#
#  Date Modified  Version Who Modified      Description of Change
#  -------------  ------- ----------------  -----------------------------------
#
# Copyright (c) 2008 by RedWolf Computer Forensics
#
#use strict;
use POSIX;

my $in = shift || die "You must enter a prefetch file.\n";
my $binary_record = 0;
# Open Input file to Read
open(IN, "< $in");

# Prepare file to be read in Binary Mode
binmode(IN);

# Get the File name
seek(IN, 16, 0);
read(IN,$binary_record,64);
$binary_record =~ s/\x00\x00/\x00\x3f/;
$binary_record =~ tr/\x00//d;
$file_name = substr($binary_record,0,rindex($binary_record,"?"));
print "File Name that was run $file_name \n\n";

my ($dev, $ino, $mode, $nlink, $uid, $gid, $rdev, $size, $atime, $mtime, $ctime, $blksize, $blocks) = ( stat($in)) [0..12];
print "Date/Time prefetch file was created ".gmtime($ctime)." \n";
print "Date/Time prefetch file was modified ".gmtime($mtime)." \n";
print "Date/Time prefetch file was last accessed ".gmtime($atime)." \n\n";


# Get Number of Times the File Was Run
seek(IN, 144, 0);
read(IN,$binary_record,4);
my $file_runs = unpack("h4",$binary_record);
$file_runs = 0 + hex(reverse $file_runs);
print "File $file_name was run $file_runs times \n\n";

# Get the Embeded Date/time of the file
seek(IN, 120, 0);
read(IN,$binary_record,8);
my ($file_embed_time_1, $file_embed_time_2) = unpack("L L",$binary_record);
my $file_embed_unix_epoch = _getTime($file_embed_time_1, $file_embed_time_2);
my $file_embed_time = gmtime($file_embed_unix_epoch);
print "$file_name Embeded date/time is $file_embed_time \n\n";

# Get the offset for the start of the files
seek(IN, 100, 0);
read(IN,$binary_record,4);
my $file_names_offset = unpack("h4",$binary_record);
$file_names_offset = 0 + hex(reverse $file_names_offset);
print "List of files and Directories whose pages are to be loaded \n\n";

# Get the offset for the size of the files section
seek(IN, 104, 0);
read(IN,$binary_record,4);
my $file_names_offset_size = unpack("h4",$binary_record);
$file_names_offset_size = 0 + hex(reverse $file_names_offset_size);

# Get the file_names
seek(IN, $file_names_offset, 0);
read(IN, $binary_record, $file_names_offset_size);
$binary_record =~ s/\x00\x00/\x00\x0A/g;
$binary_record =~ tr/\x00//d;
print $binary_record."\n\n";


#---------------------------------------------------------
# getTime()
# Get Unix-style date/time from FILETIME object
# Input : 8 byte FILETIME object
# Output: Unix-style date/time
# Thanks goes to Andreas Schuster for the below code, which he
# included in his ptfinder.pl
#---------------------------------------------------------
sub _getTime() {
	my $lo = shift;
	my $hi = shift;
	my $t;

	if ($lo == 0 && $hi == 0) {
		$t = 0;
	} else {
		$lo -= 0xd53e8000;
		$hi -= 0x019db1de;
		$t = int($hi*429.4967296 + $lo/1e7);
	};
	$t = 0 if ($t < 0);
	return $t;
}
