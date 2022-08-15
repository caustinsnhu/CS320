/*
 * Author Name: Chris Austin
 * Date: July 12, 2022
 * Course ID: CS-320
 * Description: The Contact class. This is an non-anemic domain
 *              model for Contact objects representing a typical
 *              contact object..
 */


import java.util.concurrent.atomic.AtomicLong;

public class Contact {
   private final String contactID;
   private String firstName;
   private String lastName;
   // NOTE: This is actually a phone number.  But the specification calls for the field to
   // be named 'NUMBER'
   private String number;
   private String address;

   // helper to populate unique sequential ids for the contact instances
   // NOTE: This is a hacky.  In a more real world scenario the datastore
   // or service would supply a unique and possibly sequential id.  As is
   // this is a dubious implementation.
   private static AtomicLong idGenerator = new AtomicLong();

   /**
    * A helper method to avoid repeating ourself when setting strings
    * using the reccomendation supplied in the module's discussion.
    *
    * In this approach nulls and invalid strings are replaced with the
    * supplied nullValue and if the string the supplied maxlength
    * it will be truncated to be no longer than the max length.
    *
    * @param sourceString the origional string
    * @param maxLength the max length the srting is allowed to be.
    * @param nullValue a
    * @return normalized string value
    */
   private String normalizeString(String sourceString, int maxLength, String nullValue) {
      // a holder for our normalized string.
      String val;

      if (sourceString != null && sourceString.length() > 0) {
         // setting val to the first 10 characters of the supplied sourceString
         // note we are using Math.min() here to avoid raising an exception
         // if the supplied sourceString has a length of less than 10 characters.
         val = sourceString.substring(0, Math.min(sourceString.length(), maxLength));
      } else {
         val = nullValue;
      }

      return val;
   }

   /**
    * Parametrized constructor.
    *
    * @param firstName the contact's first name
    * @param lastName the contact's last name
    * @param number the contact's phone number
    * @param address the contact's address
    */
   public Contact(String firstName, String lastName, String number, String address) {
      // use our default constructor to set the id rather
      // than repeating ourselves.
      this.contactID = String.valueOf(idGenerator.getAndIncrement());

      // DRY approach to setting the class attributes
      this.setFirstName(firstName);
      this.setLastName(lastName);
      this.setNumber(number);
      this.setAddress(address);
   }

   /**
    * Getter for the contact's unique id.
    */
   public String getContactID() {
      return contactID;
   }

   /**
    * Get the contact's first name.
    *
    * @return firstName
    */
   public String getFirstName() {
      return firstName;
   }

   /**
    * Set the contact's first name.
    *
    * @param firstName the name to be set or updated the max length for
    *                  this string is 10 characters.
    */
   public void setFirstName(String firstName) {
      this.firstName = this.normalizeString(firstName, 10, "NULL");
   }

   /**
    * Get the contact's last name
    *
    * @return lastName
    */
   public String getLastName() {
      return lastName;
   }

   /**
    * Set or update the contact's last name.
    *
    * @param lastName the name being set. The max length for this string is
    *                 10 characters.
    */
   public void setLastName(String lastName) {
      this.lastName = this.normalizeString(lastName, 10, "NULL");
   }

   /**
    * Get the contact's phone number
    * @return  number
    */
   public String getNumber() {
      return number;
   }

   /**
    * Set the contact's phone number
    * The phone number must be exactly 10 characters.
    * If not the default value of "5555555555" will be used.
    *
    * @param number The max length for this string is 10 characters.
    */
   public void setNumber(String number) {
      // if the phone number is not exactly 10 chars use the default.
      String defaultNumber = "5555555555";
      if (number != null && number.length() == 10) {
         this.number = number;
      } else {
         this.number = defaultNumber;
      }
   }

   /**
    * Ge the contact's address.
    *
    * @return address
    */
   public String getAddress() {
      return address;
   }

   /**
    * Set the or update theaddress for the contact.
    *
    * @param address the address being set. The max length for this string is
    *               30 characters.
    */
   public void setAddress(String address) {
      this.address = this.normalizeString(address, 30, "NULL");
   }
}
