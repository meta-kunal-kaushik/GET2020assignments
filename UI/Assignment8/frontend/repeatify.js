// Define a repeatify function on the String object

String.prototype.repeatify = function(repeatCount) {
    if (repeatCount > 0)
        return this.repeat(repeatCount);
    else
        return this.toString();
}