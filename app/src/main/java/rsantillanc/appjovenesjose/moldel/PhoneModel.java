package rsantillanc.appjovenesjose.moldel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by RenzoD on 15/05/2015.
 */
public class PhoneModel implements Parcelable{

    private int number;
    private String operator;

    public static final String TAG_PHONE_MODEL = "phone_model";


    public PhoneModel(int number, String operator) {
        this.number = number;
        this.operator = operator;
    }

    public static final Parcelable.Creator<PhoneModel> CREATOR = new Parcelable.ClassLoaderCreator<PhoneModel>() {
        @Override
        public PhoneModel createFromParcel(Parcel source) {
            return new PhoneModel(source);
        }

        @Override
        public PhoneModel[] newArray(int size) {
            return new PhoneModel[size];
        }

        @Override
        public PhoneModel createFromParcel(Parcel source, ClassLoader loader) {
            return null;
        }
    };

    public PhoneModel(Parcel in){
        this.number = in.readInt();
        this.operator = in.readString();
    }


        @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }


    /*Setter and Getter*/

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
