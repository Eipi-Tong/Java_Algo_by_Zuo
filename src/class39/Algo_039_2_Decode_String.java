package class39;

/**
 * ClassName: Algo_039_2_Decode_String
 * Package: class39
 * CreateTime: 2024/2/8 15:59
 * Description:
 *
 * @author tongtong zhu
 * @version 1.0
 */
// https://leetcode.com/problems/decode-string/description/
public class Algo_039_2_Decode_String {

    public static int where;

    public static String decodeString(String str) {
        where = 0;
        return f(str.toCharArray(), 0);
    }

    public static String f(char[] s, int i) {
        StringBuilder path = new StringBuilder();
        int cur = 0;
        while (i < s.length && s[i] != ']') {
            if (Character.isDigit(s[i])) {
                cur = cur * 10 + (s[i++] - '0');
            } else if (Character.isLetter(s[i])) {
                path.append(s[i++]);
            } else {
                path.append(get(f(s, i + 1), cur));
                i = where + 1;
                cur = 0;
            }
        }
        where = i;
        return path.toString();
    }

    public static String get(String str, int cnt) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            builder.append(str);
        }
        return builder.toString();
    }
}
