echo "python grepsharp.py       #test help info"
python grepsharp.py

echo "python grepsharp.py -c -p us -f FILE1.txt FILE2.txt FILE3.txt      #test the flag -c"
python grepsharp.py -c -p us -f FILE1.txt FILE2.txt FILE3.txt

echo "python grepsharp.py -c -p us -f FILE2.txt      #test the flag -c"
python grepsharp.py -c -p us -f FILE2.txt

echo "python grepsharp.py -i -p us -f FILE1.txt FILE2.txt FILE3.txt      #test the flag -i"
python grepsharp.py -i -p us -f FILE1.txt FILE2.txt FILE3.txt

echo "python grepsharp.py -p us -f FILE1.txt FILE2.txt FILE3.txt      #test the flag -p <PATTERN> and -f"
python grepsharp.py -p us -f FILE1.txt FILE2.txt FILE3.txt

echo "python grepsharp.py -r u* -f FILE1.txt FILE2.txt FILE3.txt      # test the flag -r <REGEX>"
python grepsharp.py -r u* -f FILE1.txt FILE2.txt FILE3.txt

echo "python grepsharp.py -n -r use -f FILE1.txt       #test the flag -n "
python grepsharp.py -n -r use -f FILE1.txt

echo "python grepsharp.py -l 2 -p us -f FILE1.txt FILE2.txt FILE3.txt     #test the flag -l <NUM>"
python grepsharp.py -l 2 -p us -f FILE1.txt FILE2.txt FILE3.txt

echo "python grepsharp.py -p us -f FILE1.txt FILE2.txt FILE3.txt -C 2     #test the flag -C <NUM>"
python grepsharp.py -p us -f FILE1.txt FILE2.txt FILE3.txt -C 2

