# Task
Input is a properties file which contains pairs:

key=value

where key - dot separated string and represents a translation key
and value - free text and represents a translation

It is needed to implement a method, which takes a translationKey as an input and returns appropriate translation

"String getTranslationValue(String translationKey);"

according to the following rules:

if input properties contains a key equals to the translationKey, its value should be returned.
otherwise translation value has to be looked up by the key which is reduced till the next dot, starting from the beginning of the key, and so on.

I.e. considering this input:

equipmentForm.firstName=Equipment First Name
firstName=First Name

getTranslationValue("firstName") -> "First Name"
getTranslationValue("equipmentForm.firstName") -> "Equipment First Name"
getTranslationValue("orderForm.firstName") -> "First Name"
getTranslationValue("orderView.orderForm.firstName") -> "First Name"
getTranslationValue("lastName") -> null

Please provide a number of unit tests which proof the logic of the method is working.

Please try to show in the implementation proper OOP approaches

Please give a zip with java package as a result, which also contains a properties file, or if you have a github account you can push it there and share the link.
