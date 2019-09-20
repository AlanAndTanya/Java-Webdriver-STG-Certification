package common;

import java.util.Objects;

public class Vehicle {
    private int lotNumber;
    private String watchThis;    // found that the cells had text like this: "19746036 Watch"
    private int modelYear;
    private String make;
    private String model;
    private String damageTypeText;


    public int getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getWatchThis() {
        return watchThis;
    }

    public void setWatchThis(String watchThis) {
        this.watchThis = watchThis;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDamageTypeText() {
        return damageTypeText;
    }

    public void setDamageTypeText(String damageTypeText) {
        this.damageTypeText = damageTypeText;
    }





    public void splitIntoLotNumberAndWatchThis( String source ) {
        // Yes, we split a string and fill TWO fields.
        // Found that the cells had text like this: "19746036\nWatch"
        // I did not want the logic to split that value in the ChallengeO5Test.java file.
        // It fits better here.

        int posSpace = source.indexOf( "\n" );
        if( posSpace != -1 ) {
            String leftPart = source.substring(0, posSpace);
            String rightPart = source.substring(posSpace);

            this.setLotNumber(Integer.valueOf(leftPart));
            this.setWatchThis(rightPart);
        } else {
            this.setLotNumber( Integer.valueOf(source));
            this.setWatchThis( null );
        }
    }


    @Override
    public boolean equals(Object o) {
        // see:  https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;

        Vehicle thisV = (Vehicle) o;
        // field comparison
///        return Objects.equals(make, thisV.make)
///                && Objects.equals( model, thisV.model)
///                && Objects.equals(modelYear, thisV.modelYear)    -- int is mutable.
///                && Objects.equals( lotNumber, thisV.lotNumber );   -- int is mutable.

        return Objects.equals( lotNumber, thisV.lotNumber );

    }


    @Override
    public int hashCode() {
        // see: https://www.sitepoint.com/how-to-implement-javas-hashcode-correctly/
        /// return Objects.hash( make, model, modelYear );
        return Objects.hash( lotNumber );    // while this int is mutable, it is a database table key value.
    }
}
