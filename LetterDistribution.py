"""
This program counts and stores the frequency of each letter occuring in a document.
When I started I realised that using regular expressions is not a great way to solve this problem,
as it has to run through the entire file once for each letter.
I intended to use it as a way to do comparison with the known english letter distributions.
"""
import re
import time #to measure how long the processing time was, because very large files will start to take a while
stdDist = ['e','t','a','o','i','n','s','r','h','l','d','c','u','m','f','p','g','w','y','b','v','k','x','j','q','z']
docDist ={}
t0 = time.clock() #start time

with open(input("Please enter file name with extention: ")) as inf:
      for k in stdDist:
          docDist[k] = (len(re.findall(k, inf.read().casefold())))
          inf.seek(0) #read() goes to eof and seek() moves to the offset, the position of the read/write pointer within the file default 0
      for k, v in docDist.items():
          print(k,v) #this may be printed out of stdDist order
print("Process finished in", time.clock()-t0, "seconds.") #print end time
