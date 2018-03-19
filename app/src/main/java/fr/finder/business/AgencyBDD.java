package fr.finder.business;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Gilo on 19/03/2018.
 */

public class AgencyBDD implements Parcelable {
    private List<String> administeredBy;
    private String _id;
    private String name;
    private String fonction;
    private String intitule;
    private String photo;
    private String panorama;
    private int __v;

    public AgencyBDD(List<String> administeredBy, String _id, String name, String fonction, String intitule, String photo, String panorama, int __v) {
        this.administeredBy = administeredBy;
        this._id = _id;
        this.name = name;
        this.fonction = fonction;
        this.intitule = intitule;
        this.photo = photo;
        this.panorama = panorama;
        this.__v = __v;
    }

    protected AgencyBDD(Parcel in) {
        administeredBy = in.createStringArrayList();
        _id = in.readString();
        name = in.readString();
        fonction = in.readString();
        intitule = in.readString();
        photo = in.readString();
        panorama = in.readString();
        __v = in.readInt();
    }

    public static final Creator<AgencyBDD> CREATOR = new Creator<AgencyBDD>() {
        @Override
        public AgencyBDD createFromParcel(Parcel in) {
            return new AgencyBDD(in);
        }

        @Override
        public AgencyBDD[] newArray(int size) {
            return new AgencyBDD[size];
        }
    };

    public List<String> getAdministeredBy() {
        return administeredBy;
    }

    public void setAdministeredBy(List<String> administeredBy) {
        this.administeredBy = administeredBy;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPanorama() {
        return panorama;
    }

    public void setPanorama(String panorama) {
        this.panorama = panorama;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(administeredBy);
        parcel.writeString(_id);
        parcel.writeString(name);
        parcel.writeString(fonction);
        parcel.writeString(intitule);
        parcel.writeString(photo);
        parcel.writeString(panorama);
        parcel.writeInt(__v);
    }

}
