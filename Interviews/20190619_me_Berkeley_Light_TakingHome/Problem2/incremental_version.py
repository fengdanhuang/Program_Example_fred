import pdb #python debug lib

# The function to implment the main functionality.
def IncrementVersion(version, index):
    # Parse all version numbers
    version_split = version.split('.')
    major = version_split[0]
    minor = version_split[1]
    build = version_split[2]
    revision = version_split[3]

    # Make sure the index is not out of range, and all version number is >= 0.
    if not(index <= 3 and index >= 0 and major[0] != '-' and minor[0] != '-' and build[0] != '-' and revision[0] != '-'):
        return "index must be an integer between 0 and 3, version must not be negative"
    
    # Call plus '1' operation
    modified_number = addOne(version_split, index)

    # After add '1', build returning string.
    if index == 3: res = major + '.' + minor + '.' + build + '.' + str(modified_number)
    elif index == 2: res = major + '.' + minor + '.' + modified_number + '.' + '0'
    elif index == 1: res = major + '.' + modified_number + '.' + '0' + '.' + '0'
    else: res = modified_number + '.' + '0' + '.' + '0' + '.' + '0'
    return res

# The function to do add '1' operation.
def addOne(version_split, index):
    current = version_split[index]
    if(current.isdigit()): return str(int(current) + 1)
    else:
      if current == 'z': return '27'
      else: return chr(ord(current) + 1)

if __name__ == "__main__":
    
    # All unit test cases, including edge cases.
    print "IncrementVersion('1.2.3.4', 3) => ", IncrementVersion('1.2.3.4', 3)
    print "IncrementVersion('1.2.3.4', 2) => ", IncrementVersion('1.2.3.4', 2)
    print "IncrementVersion('1.a.3.4', 1) => ", IncrementVersion('1.a.3.4', 1)
    print "IncrementVersion('1.z.3.4', 1) => ", IncrementVersion('1.z.3.4', 1)
    print "IncrementVersion('1.z.3.z', 1) => ", IncrementVersion('1.z.3.z', 1)
    print "IncrementVersion('z.z.z.z', 0) => ", IncrementVersion('z.z.z.z', 0)
    print "IncrementVersion('b.z.z.3', 0) => ", IncrementVersion('b.z.z.3', 0)
    print "IncrementVersion('b.z.-z.3', 0) => ", IncrementVersion('b.z.-z.3',0)
