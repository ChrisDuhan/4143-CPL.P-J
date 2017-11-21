#*******************************************************************
#     Regex program
#     Chris Duhan
#     CMPS 4143
#     Dr. Johnson
#     Due 10/10/2017
#*******************************************************************
#     This program is pretty interesting, I was almost able to do
#     it in two lines but it was not nice to read at all, so I 
#     made it clearer and less messy. Not a lot of things to say
#     about it overall except that in takes a specified document
#     and extracts the contents of parenthese pairs in the 
#     document, outputs them and the word count of each contents
#     to a file named parenthesescounted.txt and then gives a 
#     count of how many things it extracted.
#     Note that I say "things it extracted", these things are
#     anything that were in parentheses so they may not be normal
#     sentences.
#*******************************************************************

import re
infile = input("Please enter the name of your file with extension: ")
infile = infile.split('\n')
infile = " ".join(infile)
outfile = "parenthesescounted.txt"


with open(infile) as inf, open(outfile, 'w') as outf:
    outf.write('Chris Duhan\nThis program takes a specified document\n\
and extracts the contents of parenthese pairs in the\n\
document, outputs them and the word count of each contents\n\
to a file named parenthesescounted.txt and then gives a\n\
count of how many things it extracted.\n\
Note that I say "things it extracted", these things are\n\
anything that were in parentheses so they may not be normal\n\
sentences.\n\n')
    inList = re.findall('\((.*?)\)', inf.read(), re.DOTALL)
    #First interesting thing I found out: if you don't use re.DOTALL
    #you won't get back anything that had a newline charactor between
    #the parentheses.
    listLength = len(inList)
    outlist = []
    for item in inList:
        item = item.split()
        sentenceLength = len(item)
        item = " ".join(item) 
        item = item + "\nThe above sentence has " + str(sentenceLength) + " things in it."
        outlist.append(item)
        #Second interesting thing: I tried replacing 'item' (which was a 
        #string then became a list) with the joined list plus sentenceLegth.
        #It would then print out to the console just as I intended but would not
        #write to outfile afterwards. Thats why I append the altered item to 
        #outlist now.
    outf.write('\n\n'.join(sorted(outlist)))
    outf.write("\n\nThere were " + str(listLength) + " things within parentheses in the document \"" + infile + "\".")
