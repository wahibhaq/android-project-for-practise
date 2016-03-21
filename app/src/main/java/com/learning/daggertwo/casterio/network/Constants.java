package com.learning.daggertwo.casterio.network;

/**
 * Created by wahibulhaq on 14/03/16.
 */
public final class Constants {
    private Constants() {}

    public static final class Injection {
        private Injection() {}

        public static final class Named {
            private Named() {}
            public static final String MASHAPE_API_KEY = "X-Mashape-Key";

            public static final String RESTCOUNTRY_BASE_URL_KEY = "base_url";
            public static final String RESTCOUNTRY_BASE_URL =
                    "https://restcountries-v1.p.mashape.com/";
        }
    }
}
