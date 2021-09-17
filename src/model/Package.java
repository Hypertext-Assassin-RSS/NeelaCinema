package model;

public class Package {
   private String packageId;
   private String packageName;
   private String packageDetails;
   private double packagePrice;

   public Package() {
   }

   public Package(String packageId, String packageName, String packageDetails, double packagePrice) {
      this.setPackageId(packageId);
      this.setPackageName(packageName);
      this.setPackageDetails(packageDetails);
      this.setPackagePrice(packagePrice);
   }

   public String getPackageId() {
      return packageId;
   }

   public void setPackageId(String packageId) {
      this.packageId = packageId;
   }

   public String getPackageName() {
      return packageName;
   }

   public void setPackageName(String packageName) {
      this.packageName = packageName;
   }

   public String getPackageDetails() {
      return packageDetails;
   }

   public void setPackageDetails(String packageDetails) {
      this.packageDetails = packageDetails;
   }

   public double getPackagePrice() {
      return packagePrice;
   }

   public void setPackagePrice(double packagePrice) {
      this.packagePrice = packagePrice;
   }

   @Override
   public String toString() {
      return "Package{" +
              "packageId='" + packageId + '\'' +
              ", packageName='" + packageName + '\'' +
              ", packageDetails='" + packageDetails + '\'' +
              ", packagePrice=" + packagePrice +
              '}';
   }
}

