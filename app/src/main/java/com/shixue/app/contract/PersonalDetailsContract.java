package com.shixue.app.contract;

import com.jjs.Jbase.BaseView;

/**
 * 本页：
 * Created by jjs on 2016-11-25.
 */

public interface PersonalDetailsContract {
    interface View extends BaseView {
        void saveUserOK();
    }

    interface Model {
        void saveUserData(String name, int sex, String email, String address, String mobile);
    }
}
