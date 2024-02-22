package com.programmers.Lv2;

import java.util.Arrays;

public class PhoneBook {
    public boolean mySolution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        System.out.println(phoneBook.mySolution(new String[]{"119", "98236482", "11938473"}));
        System.out.println(phoneBook.mySolution(new String[]{"123", "456", "789"}));
        System.out.println(phoneBook.mySolution(new String[]{"12", "123", "1235", "567", "88"}));
        System.out.println(phoneBook.mySolution(new String[]{"980980980", "00000", "9809", "000", "49573874927", "4798239"}));
        System.out.println(phoneBook.mySolution(new String[]{"1234", "14", "123", "12"}));
    }
}
