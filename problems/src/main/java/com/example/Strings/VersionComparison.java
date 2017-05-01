package com.example.Strings;

/**
 * Created by shwetatrivedi1 on 2/7/17.
 */
/*
Compare two version numbers version1 and version2.

If version1 > version2 return 1,
If version1 < version2 return -1,
otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 */
public class VersionComparison {
    public int compareVersion(String a, String b) {

        String[] arr1 = a.split("\\.");
        String[] arr2 = b.split("\\.");
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<arr1.length; i++) {
            arr1[i] = arr1[i].replaceFirst("^0+(?!$)", "");
            builder.append(arr1[i]).append(".");
        }
        a = builder.deleteCharAt(builder.length()-1).toString();
        builder.setLength(0);
        for(int i=0; i<arr2.length; i++) {
            arr2[i] = arr2[i].replaceFirst("^0+(?!$)", "");
            builder.append(arr2[i]).append(".");
        }
        b = builder.deleteCharAt(builder.length()-1).toString();

        for (; a != b; a = nextSubstr(a), b = nextSubstr(b))
        {
            String current1 = curSubstr(a), current2 = curSubstr(b);

            int lenGap = current1.length() - current2.length();
            if (lenGap != 0)
            {
                return lenGap > 0 ? 1 : -1;
            }
            else if (!current1.equalsIgnoreCase(current2))
            {
                return current1.compareTo(current2) > 0 ? 1 : -1;
            }
        }
        return 0;
    }

    private static String curSubstr(String str)
    {
        int Idx = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '.')
            {
                return convert(str.substring(0, i));
            }
//            if (str.charAt(i) == '0' && i == 0 && str.length() == 1)
//                convert(str.substring(Idx, (int)str.length() - Idx));

        }
        return convert(str.substring(0, (int)str.length()));
    }

    private static String convert(String str)
    {
        if (str.length() == 0) return "0";
        return str;
    }

    private static String nextSubstr(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '.')
            {
                return str.substring(i + 1);
            }
        }
        return "0";
    }
}
