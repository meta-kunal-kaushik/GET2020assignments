// Write a program in javascript input a string and remove the consecutive repeating
class RemoveConsecutiveElementsFromString {
    removeConsecutiveElements(string) {
        if (string.length == 1)
            return "output : " + string;
        else {
            var output = "";
            for (var index1 = 0; index1 < string.length - 1; index1++) {
                for (var index2 = index1; index2 < string.length; index2++) {
                    //if first value is unique
                    if (index2 == 0 && string[index2] != string[index2 + 1]) {
                        output += string[index2];
                    }
                    // if any intermediate or last value is unique
                    if (string[index2] != string[index2 + 1] && string[index2 + 1] != string[index2 + 2]) {
                        output += string[index2 + 1];
                        index1 = index2;
                        break;
                    }
                }
            }
            if (output.length != 0)
                return "output : " + output;
            else
                return "output : ....EMPTY STRING LEFT....";
        }
    }
}