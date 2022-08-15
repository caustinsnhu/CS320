/*
 * Author Name: Chris Austin
 * Date: July 12, 2022
 * Course ID: CS-320
 * Description: Test cases for the Contact Service. These test cases
 *              exercise the public methods of the ContactService class.
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

   @Test
   @DisplayName("Create a service and add a contact.")
   void addContact() {
      ContactService service = new ContactService();
      Contact contact = service.AddContact("Joe", "Smith", "123456780", "123 Happy St, Happy TX");
      assertEquals("Joe", contact.getFirstName());
      assertEquals(1, service.Count());
   }

   @Test
   @DisplayName("Update a contact's first name via it's id")
   void testUpdateFirstName() {
      ContactService service = new ContactService();
      Contact contact = service.AddContact("Joe", "Smith", "123456780", "123 Happy St, Happy TX");
      assertEquals("Joe", contact.getFirstName());

      Contact updated = service.UpdateFirstName(contact.getContactID(), "Jason");
      assertEquals("Jason", contact.getFirstName());
   }

   @Test
   @DisplayName("Update a contact's last name via it's id")
   void testUpdateLastName() {
      ContactService service = new ContactService();
      Contact contact = service.AddContact("Joe", "Smith", "123456780", "123 Happy St, Happy TX");
      assertEquals("Smith", contact.getLastName());

      Contact updated = service.UpdateLastName(contact.getContactID(), "Jones");
      assertEquals("Jones", contact.getLastName());
   }

   @Test
   @DisplayName("Update a contact's number via it's id")
   void testUpdateNumber() {
      ContactService service = new ContactService();
      Contact contact = service.AddContact("Joe", "Smith", "123456780", "123 Happy St, Happy TX");
      assertEquals("Smith", contact.getLastName());

      Contact updated = service.UpdateNumber(contact.getContactID(), "0234567890");
      assertEquals("0234567890", contact.getNumber());
   }

   @Test
   @DisplayName("Update a contact's address via it's id")
   void testUpdateAddress() {
      ContactService service = new ContactService();
      Contact contact = service.AddContact("Joe", "Smith", "123456780", "123 Happy St, Happy TX");
      assertEquals("123 Happy St, Happy TX", contact.getAddress());

      Contact updated = service.UpdateAddress(contact.getContactID(), "456 Happy St, Happy TX");
      assertEquals("456 Happy St, Happy TX", contact.getAddress());
   }

   @Test
   @DisplayName("Delete a contact by it's id")
   void deleteContact() {
      ContactService service = new ContactService();
      Contact contact = service.AddContact("Joe", "Smith", "123456780", "123 Happy St, Happy TX");
      assertEquals("Smith", contact.getLastName());

      service.DeleteContact(contact.getContactID());
      assertEquals(0, service.Count());
   }

}