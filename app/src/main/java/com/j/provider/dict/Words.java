package com.j.provider.dict;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Administrator on 2015/8/22.
 */
public final class Words {
    public static String AUTHORITY = "com.j.provider.dict.DictProvider";

    public static final class Word implements BaseColumns {
        public final static String _ID = "_id";
        public final static String WORD = "word";
        public final static String DETAIL = "detail";

        public final static Uri DICT_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/words");
        public final static Uri WORD_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/word");
    }

}
