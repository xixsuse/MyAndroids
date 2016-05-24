package com.j.service.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2015/8/25.
 */
public class Person implements Parcelable {
    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in.readInt(), in.readString(), in.readString());
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
    Integer id;
    String name;
    String pass;

    public Person() {
    }

    public Person(Integer id, String name, String pass) {
        super();
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;
        if (name == null) {
            if (person.name != null) {
                return false;
            }
        } else if (!name.equals(person.name)) {
            return false;
        }
        if (pass == null) {
            if (person.pass != null) {
                return false;
            }
        } else if (!pass.equals(person.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        int prime = 31;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((pass == null) ? 0 : pass.hashCode());
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(pass);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
