import sys
import argparse
import re

# The class is used for read, process and deliver all arguments.
class ProcessArgument(object):
    def __init__(self):
        self.program = sys.argv[0]

    def print_help(self):
        print
        print self.program," [OPTIONS] -f FILE1 "
        print self.program," [OPTIONS] -f FILE1 FILE2 FILE3 ... "
        print

    def read_arguments(self):
        if len(sys.argv) == 1:
            self.print_help()
            sys.exit(0)
        if len(sys.argv) > 1:
            parser = argparse.ArgumentParser(description='....')
            parser.add_argument('-c', '--is_count',
                                action='store_true',
                                help="Return count of matching lines per file.")
            parser.add_argument('-i', '--is_prepend',
                                action='store_true',
                                help="Prepend the output lines with filename.")
            parser.add_argument('-p', '--pattern',
                                nargs="?",
                                dest="pattern",
                                help="String pattern to search.")
            parser.add_argument('-r', '--regex',
                                nargs="?",
                                dest="regex",
                                help="Regex pattern to search (use C# regex).")
            parser.add_argument('-n', '--is_inverse',
                                action='store_true',
                                help="Inverse the match. (Show all lines that do not match the pattern).")
            parser.add_argument('-l', '--num-lines',
                                nargs="?",
                                dest="output_num",
                                help="Print NUM lines of output, wait for user input, then show next NUM lines.")
            parser.add_argument('-C', '--count-num',
                                nargs="?",
                                dest="lt_num",
                                help="Print NUM lines of leading and trailing context.")
            parser.add_argument('-f', '--file',
                                nargs="+",
                                dest="files",
                                help="All input files.")
            self.args = parser.parse_args()

    def print_arguments(self):
            print "\n"
            print "    The program is:", self.program
            print "    args = ", self.args
            print ""

    def get_arguments(self):
            return self.args


# Implement the -c flag
def search_is_count():
    for ifile in files:
        with open(ifile,'r') as f:
            count = 0
            for line in f: 
                if pattern in line:
                    count = count+1
        print ifile, ": ", count

# Implement the -n flag
def search_is_inverse():
    oi = 0
    for ifile in files:
        with open(ifile,'r') as f:
            lines = f.readlines()
            for i in range(0, len(lines)):
                if not re.search(regex, lines[i]):
                    if is_prepend:
                        print_leading_lines(i, lines, ifile)
                        print ifile,": ", "NOT " + regex,": ", line[i]
                        print_trailing_lines(i, lines, ifile)
                    else:
                        print_leading_lines(i, lines)
                        print "NOT " + regex,": ", lines[i]
                        print_trailing_lines(i, lines)
                    oi = oi+1
                    if oi == output_num:
                        raw_input("Press Enter to show next matched line...")
                        oi = 0

# print NUM lines of leading context, part of the -C <NUM> flag functionality.
def print_leading_lines(i, lines, ifile=None):
    if lt_num > 0:
        j = i-lt_num
        while j >= 0 and j >= i-lt_num and j < i:
            if ifile is not None: print ifile + ": ", lines[j]
            else: print lines[j]
            j = j+1

# print NUM lines of trailing context, part of the -C <NUM> flag functionality
def print_trailing_lines(i, lines, ifile=None):
    if lt_num > 0:
        j = i+1
        while j < len(lines) and j <= i+lt_num:
            if ifile is not None: print ifile + ": ", lines[j]
            else: print lines[j]
            j = j+1
        print "----"

# Implement the -p <PATTERN> flag, with -i, -l, -C
def search_pattern():
    oi = 0
    for ifile in files:
        with open(ifile,'r') as f:
            lines = f.readlines()
            for i in range(0, len(lines)):
                if pattern in lines[i]:
                    if is_prepend:
                        print_leading_lines(i, lines, ifile)
                        print ifile,": ", pattern,": ", lines[i]
                        print_trailing_lines(i, lines, ifile)
                    else:
                        print_leading_lines(i, lines)
                        print pattern,": ", lines[i]
                        print_trailing_lines(i, lines)
                    oi = oi+1
                    if oi == output_num:
                        raw_input("Press Enter to show next matched line...")
                        oi = 0

# Implement the -r <Reges> flag, with -i, -l, -C
def search_regex():
    oi = 0
    for ifile in files:
        with open(ifile,'r') as f:
            lines = f.readlines()
            for i in range(0, len(lines)):
                if re.search(regex, lines[i]):
                    if is_prepend:
                        print_leading_lines(i, lines, ifile)
                        print ifile,": ", regex,": ", lines[i]
                        print_trailing_lines(i, lines, ifile)
                    else:
                        print_leading_lines(i, lines)
                        print regex,": ", lines[i]
                        print_trailing_lines(i, lines)
                    oi = oi+1
                    if oi == output_num:
                        raw_input("Press Enter to show next matched line...")
                        oi = 0

# The major function to implment the grep search
def search(files, pattern, regex, is_count=False, is_prepend=False, is_inverse=False, output_num=None, lt_num=None):
    if is_count:
        search_is_count()
        return 
    if is_inverse:
        search_is_inverse()
        return
    if pattern is not None: search_pattern()
    if regex is not None: search_regex()


def get_check_print_arguments():
    #get the arguments
    process_argument = ProcessArgument()
    process_argument.read_arguments()
    process_argument.print_arguments()
    arguments = process_argument.get_arguments()
    
    # Read command line flag arguments into parameters
    files = arguments.files
    pattern = arguments.pattern
    regex = arguments.regex
    is_count = arguments.is_count
    is_prepend = arguments.is_prepend
    is_inverse = arguments.is_inverse
    
    # Program robust check
    if files is None:
        print "No files are provided!\n"
        sys.exit(0)
    if pattern is None and regex is None:
        print "Neither patterns nor regex are provided!\n"
        sys.exit(0)
    
    if arguments.output_num is not None:
        output_num = int(arguments.output_num)
    else:
        output_num = -1
    
    if arguments.lt_num is not None:
        lt_num = int(arguments.lt_num)
    else:
        lt_num = -1
    
    print "    The files are: ", files
    print "    The pattern is: ", pattern
    print "    The regex is: ", regex
    print "    The is_count = ", is_count
    print "    The is_prepend = ", is_prepend
    print "    The is_inverse = ", is_inverse
    print "    The output_num = ", output_num
    print "    The lt_num = ", lt_num
    print 
    return files, pattern, regex, is_count, is_prepend, is_inverse, output_num, lt_num
  

if __name__ == '__main__':
    # get all parameters
    files, pattern, regex, \
    is_count, is_prepend, is_inverse, \
    output_num, lt_num = get_check_print_arguments()

    # Call the major search function.
    print "---------------------------------------The search result---------------------------------------------------------------\n"
    search(files, pattern, regex, is_count, is_prepend, is_inverse, output_num, lt_num)
