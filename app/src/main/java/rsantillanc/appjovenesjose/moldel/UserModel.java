package rsantillanc.appjovenesjose.moldel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import rsantillanc.appjovenesjose.util.Const;

/**
 * Created by RenzoD on 15/05/2015.
 */
public class UserModel implements Parcelable {

    private String objectId;
    private String username;
    private String name;
    private String email;
    private boolean emailVerified;
    private String createdAt;
    private String updatedAt;
    private List<PhoneModel> phoneNumbers;
    private int age;
    private String birthday;
    private String socialLogin;
    private int status;
    private String type;
    private String sessionToken;

    public static final String TAG_USER_MODEL = "user_model";



    // Creator
    public static final Parcelable.Creator<UserModel> CREATOR = new Parcelable.ClassLoaderCreator<UserModel>(){

        @Override
        public UserModel createFromParcel(Parcel source) {
            return new UserModel(source);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[0];
        }

        @Override
        public UserModel createFromParcel(Parcel source, ClassLoader loader) {
            return null;
        }

    };

    /* Contructors */

    public UserModel() {
        if (phoneNumbers == null)
            phoneNumbers = new ArrayList<PhoneModel>();

        this.objectId = Const.TAG_EMPTY;
        this.username = Const.TAG_EMPTY;
        this.name = Const.TAG_EMPTY;
        this.emailVerified = false;
        this.email = Const.TAG_EMPTY;
        this.createdAt = Const.TAG_EMPTY;
        this.updatedAt = Const.TAG_EMPTY;
        this.age = 0;
        this.birthday = Const.DATE_DEFAULT;
        this.socialLogin = "google";
        this.status = -1;
        this.type = "standard";
        this.sessionToken = Const.TAG_EMPTY;

    }

    public UserModel(String objectId
            , String userName
            , String name
            , String email
            , boolean emailVerified
            , String createdAt
            , String updatedAt
            , List<PhoneModel> phoneNumbers
            , int age
            , String birthday
            , String socialLogin
            , int status
            , String type
            ,String sessionToken) {

        this.objectId = objectId;
        this.username = userName;
        this.name = name;
        this.email = email;
        this.emailVerified = emailVerified;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.phoneNumbers = phoneNumbers;
        this.age = age;
        this.birthday = birthday;
        this.socialLogin = socialLogin;
        this.status = status;
        this.type = type;
        this.sessionToken = sessionToken;
    }

    /*Custom*/
    public UserModel (Parcel source){

        this.objectId = source.readString();
        this.username = source.readString();
        this.name = source.readString();
        this.email = source.readString();
        this.emailVerified = source.readByte() != 0x00;
        this.createdAt = source.readString();
        this.updatedAt = source.readString();
        this.phoneNumbers = new ArrayList<PhoneModel>();
        source.readTypedList(phoneNumbers, PhoneModel.CREATOR);
        this.age = source.readInt();
        this.birthday = source.readString();
        this.socialLogin = source.readString();
        this.status = source.readInt();
        this.type = source.readString();
        this.sessionToken = source.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(objectId);
        dest.writeString(username);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeByte((byte) (emailVerified ? 0x01 : 0x00));
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeTypedList(phoneNumbers);
        dest.writeInt(age);
        dest.writeString(birthday);
        dest.writeString(socialLogin);
        dest.writeInt(status);
        dest.writeString(type);
        dest.writeString(sessionToken);

    }

    @Override
    public String toString(){
        String console;

            console =  "\n\n";
            console +=  "+-------------------- UserModel --------------------\n";
            console += "| objectId: " +objectId+ "\n";
            console += "| username: " + username + "\n";
            console += "| name: " +name+ "\n";
            console += "| email: " +email+ "\n";
            console += "| emailVerified: " +emailVerified+ "\n";
            console += "| createdAt: " +createdAt+ "\n";
            console += "| updatedAt: " +updatedAt+ "\n";
            console += "| phoneNumbers: " +phoneNumbers+ "\n";
            console += "| age: " +age+ "\n";
            console += "| birthday: " +birthday+ "\n";
            console += "| socialLogin: " +socialLogin+ "\n";
            console += "| status: " +status+ "\n";
            console += "| type: " +type+ "\n";
            console += "| sessionToken: " +sessionToken+ "\n";
            console += "+-------------------- UserModel --------------------\n";

        return console;
    }



    /*Setter and Getter*/

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<PhoneModel> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneModel> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSocialLogin() {
        return socialLogin;
    }

    public void setSocialLogin(String socialLogin) {
        this.socialLogin = socialLogin;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSessionToken() {
        return sessionToken;
    }
    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
