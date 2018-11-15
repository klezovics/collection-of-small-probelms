package com.klezovich.small_problems.olympiad;

import java.util.Scanner;

/**
 *
 * Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
 */
public class TimeConversion {

    enum Period {
        AM, PM
    };

    static class TimeAmPm {

        int hh;
        int mm;
        int ss;
        Period p;

        TimeAmPm(String timeStr) {
            String hhMMss = timeStr.substring(0, timeStr.length() - 2);
            String AmOrPm = timeStr.substring(timeStr.length() - 2);

            String[] comp = hhMMss.split(":");
            hh = new Integer(comp[0]);
            mm = new Integer(comp[1]);
            ss = new Integer(comp[2]);
            p = Period.valueOf(AmOrPm);

        }

        boolean timeIsMidnight() {
            if (hh == 12 && mm == 0 && ss == 0 && p == Period.AM) {
                return true;
            }
            return false;
        }

        boolean timeIsMidday() {
            if (hh == 12 && mm == 0 && ss == 0 && p == Period.PM) {
                return true;
            }
            return false;
        }

        String toMilitaryTime() {

            if (p == p.AM) {
                if (timeIsMidnight()) {
                    return "00:00:00";
                }

                String result = String.format("%02d:%02d:%02d", hh == 12 ? 0 : hh, mm, ss);
                return result;

            } else if (p == p.PM) {
                if (timeIsMidday()) {
                    return "12:00:00";
                }
                
                String result = String.format("%02d:%02d:%02d", hh == 12 ? 12 : hh+12, mm, ss);
                return result;
            }

            return null;

        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String TimeStr = in.nextLine();
        TimeAmPm time = new TimeAmPm(TimeStr);
        String militaryTime = time.toMilitaryTime();
        System.out.println(militaryTime);

    }

}
