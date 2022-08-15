/*
 * Author Name: Chris Austin
 * Date: July 12, 2022
 * Course ID: CS-320
 * Description: Test cases for the Contact class. These test cases
 *              exercise the public methods of the Contact class to ensure
 *              we are conforming to our specs.
 */


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactTest {

   /**
    * Test that contact ids are incrementing as expected.
    *
    * Ensure that the contact id test is ran in a deterministic manner so
    * we can ensure ids are incrementing as expected.
    */
   @Test
   @DisplayName("Contact IDs are sequential.")
   @Order(0)
   void testContactID() {
      Contact firstContact = new Contact("f", "l", "n", "a");
      assertEquals("0", firstContact.getContactID());
      Contact next = new Contact("f", "l", "n", "a");
      long id = Long.parseLong(next.getContactID());
      assertTrue(id > 0);
   }

   /**
    * Test that first names update as expected with valid input.
    */
   @Test
   @DisplayName("First name is set and updated correctly.")
   void testFirstName() {
      Contact contact = new Contact("FirstName", "l", "n", "a");
      assertEquals("FirstName", contact.getFirstName());
      contact.setFirstName("Joe");
      assertEquals("Joe", contact.getFirstName());
   }

   /**
    * Test that first names update as expected with null inputs.
    */
   @Test
   @DisplayName("First name cannot be null or a zero length string")
   void testFirstNameNullInput() {
      Contact contact = new Contact(null, "l", "n", "a");
      assertEquals("NULL", contact.getFirstName());
      contact.setFirstName("");
      assertEquals("NULL", contact.getFirstName());

   }

   /**
    * Test that first names update as expected with long inputs.
    */
   @Test
   @DisplayName("First name must be 10 characters or less.")
   void testFistNameLongInput() {
      Contact contact = new Contact("12345678901234567890", "l", "n", "a");
      assertEquals("1234567890", contact.getFirstName());
      contact.setFirstName("Thisisalongfirstname");
      assertEquals("Thisisalon", contact.getFirstName());
   }

   /**
    * Test that the contact's last name can be set with valid values.
    */
   @Test
   @DisplayName("Set and update last names.")
   void validLastName() {
      // Valid last names
      Contact contact = new Contact("FirstName", "LastName", "n", "a");
      assertEquals("LastName", contact.getLastName());
      contact.setFirstName("Smith");
      assertEquals("Smith", contact.getFirstName());
   }
   /**
   * Test that the contact's last name can not be null
   */
   @Test
   @DisplayName("Last names cannot be null or zero length stigns.")
   void nullLastNames() {
      // null last names
      Contact contact = new Contact("Joe", "", "n", "a");
      assertEquals("NULL", contact.getLastName());
      contact.setLastName(null);
      assertEquals("NULL", contact.getLastName());
   }
   /**
    * Test that the contact's last name can not be longer than 10 characters.
    */
   @Test
   @DisplayName("Last names cannot be greater than 10 chars.")
   void longLastNames() {
      // long last names
      Contact contact = new Contact("Joe", "AAAAAAAAAAAAAAAAAA", "n", "a");
      assertEquals("AAAAAAAAAA", contact.getLastName());
      contact.setFirstName("ThisisalongLastname");
      assertEquals("Thisisalon", contact.getFirstName());
   }

   /**
    * Test valid contact numbers.
    */
   @Test
   @DisplayName("Contact number can be set and updated.")
   void testNumber() {
      // Valid number
      Contact contact = new Contact("Joe", "Smith", "1234567890", "a");
      assertEquals("1234567890", contact.getNumber());
      contact.setNumber("0123456789");
      assertEquals("0123456789", contact.getNumber());
   }

   /**
    * Test short contact numbers.
    */
   @Test
   @DisplayName("Contact number cannot be less than 10 chars.")
   void shortNumber() {
      // short number
      Contact contact = new Contact("Joe", "Smith", "1234567890", "a");
      contact.setNumber("123456789");
      assertEquals("5555555555", contact.getNumber());

      // Empty number
      contact.setNumber("");
      assertEquals("5555555555", contact.getNumber());
   }

   /**
    * Test null contact numbers.
    */
   @Test
   @DisplayName("Contact number cannot be null")
   void nullNumber() {
      // null number
      Contact contact = new Contact("Joe", "Smith", "1234567890", "a");
      contact.setNumber(null);
      assertEquals("5555555555", contact.getNumber());
   }

   /**
    * Test long contact numbers.
    */
   @Test
   @DisplayName("Contact number cannot be more than 10 chars.")
   void longNumber() {
      // null number
      Contact contact = new Contact("Joe", "Smith", "1234567890", "a");
      contact.setNumber("1234567890125443");
      assertEquals("5555555555", contact.getNumber());
   }


   /**
    * Can set and update the address
    */
   @Test
   @DisplayName("Set and get the address")
   void setAddress() {
      // Valid Address
      String add1 = "123 Elm Kay, TX 75555";
      String add2 = "321 K St. Kay, TX 75555";
      Contact contact = new Contact("Joe", "Smith", "1234567890", add1);
      assertEquals(add1, contact.getAddress());
      contact.setAddress(add2);
      assertEquals(add2, contact.getAddress());
   }

   /**
    * Handle adresses longer than 30 chars.
    */
   @Test
   @DisplayName("Addresses longer than 30 chars will be truncated")
   void setLongAddress() {
      String longAdd = "7821 N. Western Ave Frankfurger, TX 75551";
      Contact contact = new Contact("Joe", "Smith", "1234567890", longAdd);
      assertEquals("7821 N. Western Ave Frankfurge", contact.getAddress());
      String longAdd2 = "2121 N. Western Ave Frankfurger, TX 75551";
      contact.setAddress(longAdd2);
      assertEquals("2121 N. Western Ave Frankfurge", contact.getAddress());
   }

   /**
    * Handle empty address.
    */
   @Test
   @DisplayName("Address cannot be empty")
   void setEmptyAddress() {
      Contact contact = new Contact("Joe", "Smith", "1234567890", "");
      // Null and empty address
      assertEquals("NULL", contact.getAddress());
      contact.setAddress("");
      assertEquals("NULL", contact.getAddress());
   }

   /**
    * Handle null address.
    */
   @Test
   @DisplayName("Address cannot be null")
   void setNullAddress() {
      Contact contact = new Contact("Joe", "Smith", "1234567890", null);
      assertEquals("NULL", contact.getAddress());
      contact.setAddress(null);
      assertEquals("NULL", contact.getAddress());
   }
}