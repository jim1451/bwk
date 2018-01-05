package com.shixue.app.model;

import android.content.Context;
import android.util.Log;

import com.jjs.Jbase.BaseModel;
import com.shixue.app.contract.PersonalDetailsContract;
import com.shixue.app.utils.HTTPutils;


/**
 * 本页：
 * Created by jjs on 2016-11-25.
 */

public class PersonalDetailsModel extends BaseModel<PersonalDetailsContract.View> implements PersonalDetailsContract.Model {

    public PersonalDetailsModel(Context context, PersonalDetailsContract.View view) {
        super(context, view);
    }

    @Override
    public void saveUserData(String name, int sex, String email, String address, String mobile) {
        Log.e("saveUserData", name + "  " + sex + "  " + email + "  " + "  " + address + "   " + mobile);

        HTTPutils.updateUser(mobile, name, sex, email, address, new HTTPutils.OnTaskClick() {
            @Override
            public void onSuccess(Object o) {
                mView.saveUserOK();
            }

            @Override
            public void onError(String ex) {
                mView.showToast(ex);
            }
        });
    }
}
