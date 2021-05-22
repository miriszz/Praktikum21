package Blatt03;

public class Search {

    public static long worst_case_calculation(long n) {
        return (long) ((3 * Math.pow(n, 2) + 7 * n - 10) / 2);
    }

    public static long exponentialSearch(long x) {
        long m = 1;
        while (worst_case_calculation(m) <= x) {
            m *= 2;
        }
        return m;
    }

    public static void ternarySearch(long x) {
        long r = exponentialSearch(x);
        long l = r / 2;
        long res = internal_ternary_search(l, r, x);
        System.out.println("Ergebnis: " + "T(" + res + ") = " + worst_case_calculation(res));
    }


    private static long internal_ternary_search(long l, long r, long x) {
        System.out.print("links: " + "T(" + l + ") = " + worst_case_calculation(l) + ", ");
        System.out.println("rechts: " + "T(" + r + ") = " + worst_case_calculation(r));
        if (l == r - 1) {
            return l;
        } else {
            long s1 = l + ((r - l) / 3);
            long s2 = l + (2 * (r - l) / 3);
            if (worst_case_calculation(s1) <= x && worst_case_calculation(s2) <= x) {
                if (worst_case_calculation(s1) > worst_case_calculation(s2)) {
                    return internal_ternary_search(s1, r, x);
                } else {
                    return internal_ternary_search(s2, r, x);
                }
            } else {
                if (worst_case_calculation(s1) > x && worst_case_calculation(s2) <= x) {
                    return internal_ternary_search(s2, s1, x);
                } else if (worst_case_calculation(s1) <= x && worst_case_calculation(s2) > x) {
                    return internal_ternary_search(s1, s2, x);
                } else {
                    if (worst_case_calculation(s1) > worst_case_calculation(s2)) {
                        return internal_ternary_search(l, s2, x);
                    } else {
                        return internal_ternary_search(l, s1, x);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("FEHLER: Es muss genau eine positive ganze Zahl uebergeben werden.");
        } else {
            try {
                Long.parseLong(args[0]);
            } catch (Exception e) {
                System.out.println("FEHLER: Es muss genau eine positive ganze Zahl uebergeben werden.");
                System.exit(0);
            }
            long x = Long.parseLong(args[0]);
            if (x <= 0) {
                System.out.println("FEHLER: Es muss genau eine positive ganze Zahl uebergeben werden.");
            } else {
                ternarySearch(x);
            }
        }
    }
}
