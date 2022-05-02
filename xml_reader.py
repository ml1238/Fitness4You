# April 7th, 2022
# reads an xml file and pulls the step and miles
# from the file and stores them into a nested dictionary using
# 'Steps' and 'Miles' as keys. Steps and Miles are stored inside
# another dictionary called 'data' that uses the Dates as a key
# end of code prints out the contents of data

import xml.etree.ElementTree as ET

# debug varibale
debug = 1


def xml_read(file):
    # mytree becomes the identified parse tree in the .xml file
    mytree = ET.parse(file)
    myroot = mytree.getroot()

    # initialize empty dictionary for data
    data = {}

    # loop reads in data
    for x in myroot:

        # node measures steps
        if x.attrib.get('type') == 'HKQuantityTypeIdentifierStepCount':

            key = x.attrib.get('creationDate')
            # slicing the string so we get only the hard date (year-month-day)
            key = key[:10]

            # we are NOT at a new date
            if key in data:
                # add the step value onto the steps already counted
                data[str(key)]['Steps'] = int(data[str(key)]['Steps']) + int(x.attrib.get('value'))

            # we ARE at a new date
            else:
                data[str(key)] = {'Steps': x.attrib.get('value')}

        # check if the node measures miles
        elif x.attrib.get('type') == 'HKQuantityTypeIdentifierDistanceWalkingRunning':

            key = x.attrib.get('creationDate')
            # slicing the string so we get only the hard date (year-month-day)
            key = key[:10]

            # we are NOT at a new date
            if key in data:
                # check if we have miles on the date
                if 'Miles' in data[key]:
                    data[str(key)]['Miles'] = float(data[str(key)]['Miles']) + float(x.attrib.get('value'))
                # miles not on the date
                else:
                    # add the mile value onto the miles already counted
                    data[key]['Miles'] = x.attrib.get('value')

            # we ARE at a new date
            else:
                data[str(key)] = {'Miles': x.attrib.get('value')}

    # print the contents of data
    if debug == 1:
        for key, value in data.items():
            print(key, ' : ', value)

    return data

