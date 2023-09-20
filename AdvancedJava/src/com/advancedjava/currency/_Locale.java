package com.advancedjava.currency;

import java.util.Locale;

public class _Locale {

    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println("locale getcountry: " + locale.getCountry());
        System.out.println("locale displaylanguage: " + locale.getDisplayLanguage());
        System.out.println("locale getLanguage: " + locale.getLanguage());
        System.out.println("locale get display name: " + locale.getDisplayName());
        System.out.println("locale get display name: " + locale);
    }

}
