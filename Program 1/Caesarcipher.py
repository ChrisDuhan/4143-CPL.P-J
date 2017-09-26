#*******************************************************************
#     Simple Caesar Cipher
#     Chris Duhan
#     CMPS 4143
#     Dr. Johnson
#     Due 09/26/2017
#*******************************************************************
#     A very simple caesar or shift cipher, if I were to go back and
#     do it again I would follow some more standard cryptology
#     methods, like standard grouping, and ignoring whitespace,
#     punctuation and the case of each letter.
#     It reads the message to be processed into a string, and 
#     processes it charactor by charactor, then outputs it to
#     a different file.
#*******************************************************************

#*******************************************************************
#     get_mode()
#     Parameters: None
#     Complexity: O(1)
#     A discussion of what the method/function does and required
#     parameters as well as return value. Also indicate the compexity
#     of this function (worst case)
#*******************************************************************
def get_mode():
  while True:
    mode = input('Do you wish to encrypt or decrypt a file? (E/D): ').lower()
    if mode == 'e':
      return mode
    elif mode == 'd':
      return mode
    else:
      print('Please enter either "e" for encrypt or "d" for decrypt: ')

#*******************************************************************
#     process(string, char, int)
#     Parameters: text-the string containing the text to be
#                 encrypted or decrypted, 
#                 mode-the single charactor used to determine 
#                 encryption or decryption,
#                 shift-the integer offset for the shift cipher
#     Complexity: O(n)
#     If a charactor is not in the alphabet it is just appended to
#     the output string, if it is in the alphabet it is checked to
#     determine case, and both cases are handled in their own
#     section. The complexity is O(n) where n is the number of 
#     alphabetic charactors in the input string.
#*******************************************************************
def process(text, mode, shift):
  if mode is 'd':
    shift = -shift
  processed_text = ""
  
  for c in text:
      if c.isalpha():
          num = ord(c)
          num += shift

          if c.isupper():
             if num > ord('Z'):
                 num -= 26
             elif num < ord('A'):
                 num += 26

          elif c.islower():
             if num > ord('z'):
                 num -= 26
             elif num < ord('a'):
                 num += 26

          processed_text = processed_text +chr(num)

      else:
          processed_text += c

  return processed_text

#*******************************************************************
#     encrypt(string, char, int)
#     Parameters: message-the string containing the text to be
#                 encrypted, 
#                 mode-the single charactor used to determine 
#                 encryption or decryption,
#                 shift-the integer offset for the shift cipher
#     Complexity: O(1)
#     This function just gives the parameters to the process()
#     function, it is no different from decrypt() and actually 
#     is redundant to even have, but it makes the code very easy
#     to follow logically.
#*******************************************************************
def encrypt(message, mode, shift):
  return process(message, mode, shift)

#*******************************************************************
#     decrypt(string, char, int)
#     Parameters: message-the string containing the text to be
#                 encrypted, 
#                 mode-the single charactor used to determine 
#                 encryption or decryption,
#                 shift-the integer offset for the shift cipher
#     Complexity: O(1)
#     This function just gives the parameters to the process()
#     function, it is no different from encrypt() (see above)
#*******************************************************************
def decrypt(message, mode, shift):
  return process(message, mode, shift)

#*******************************************************************
#     __main__
#*******************************************************************
infile = input("Enter the name of your file, with extension: ")
with open(infile, 'r') as ifile:
    data = ifile.read().replace('\n', '')
outfile = "processed_" + infile
print(infile)
print(outfile)
encrypt_or_decrypt = get_mode()
shift_number = input("Enter your shift number: ")

if encrypt_or_decrypt == 'e':
    outdata = encrypt(data, encrypt_or_decrypt, shift_number)
else:
    outdata = decrypt(data, encrypt_or_decrypt, shift_number)
    
with open(outfile, "w") as ofile:
    ofile.write(outdata)
