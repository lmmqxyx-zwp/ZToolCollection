package com.by.ztc.jmu;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestDBT {

    public static void main(String[] args) {

        TestDB tdb = new TestDB();
        try {
            List l = tdb.GetDepartments();
            if (l != null) {
                System.out.println(l.size());
                for (Object lo: l
                     ) {
                    forEachObject(l);
                    if (lo instanceof Map) {
                        Map m = (Map) lo;
                        Set s = m.keySet();
                        forEachObject(s);
                        Set<String> keys = s;
                        for (String key: keys
                             ) {
                            System.out.println(key + " = " + m.get(key));
                        }
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取List或Set中存储的Object的类型
     *
     * @param ls List | Set
     */
    public static void forEachObject(Object ls) {
        if (ls == null) {
            return ;
        }
        if (ls instanceof List) {
            List l = (List) ls;
            int lc = 0;
            for (Object lo: l
                 ) {
                System.out.println("下标 - " + lc + " - 类型 - " + lo.getClass());
                lc ++;
            }
        } else if(ls instanceof Set) {
            Set s = (Set) ls;
            int sc = 0;
            for (Object so: s
                    ) {
                System.out.println("下标 - " + sc + " - 类型 - " + so.getClass());
                sc ++;
            }
        }
    }

}
