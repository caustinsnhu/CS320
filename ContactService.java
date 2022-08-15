/*
 * Author Name: Chris Austin
 * Date: July 12, 2022
 * Course ID: CS-320
 * Description: The Contact Service. This is db-like api
 * for working with Contacts.
 */

import java.util.HashMap;

/**
 * A class that provides a way to access an in-memory store
 * of Contacts and perform basic crud operations on the contacts.
 */
public class ContactService {
   // The internal data store for the contacts.
   // A hashmap was chosen because:
   // 1) A hasmap's runtime complextity is O(1) vs something like an array list which is O(n).
   // 2) By using the Contact's object id as the key it allows simple access removing the need to
   //    have to iterate an array like structure.
   // 3) A hasmap will closer resemble an actual data store where items are queried by value.
   private final HashMap<String, Contact> contacts;

   /**
    * Default constructor initializes the contact's data store.
    */
   public ContactService() {
      this.contacts = new HashMap<>();
   }

   /**
    * Add a contact to the datastore.
    * @param firstName the first name of the contact.
    * @param lastName the last name of the contact.
    * @param number the contact's phone number.
    * @param address the contact's address
    * @return the contact created by the service.
    */
   public Contact AddContact(String firstName, String lastName, String number, String address) {
      Contact contact = new Contact(firstName, lastName, number, address);
      // add the new contact to the datastore by querying the contact's contactID
      // and using that as a key.
      this.contacts.put(contact.getContactID(), contact);
      return contact;
   }

   /**
    * Delete a contact by it's id.
    * @param contactId the unique id of a contact that will be deleted.
    */
   public void DeleteContact(String contactId) {
      // use the remove method of the hashmap to remove the contact.
      this.contacts.remove(contactId);
   }

   /**
    * Update a contact's first name by it's id.
    * @param contactId the id of the contact we'd like to update.
    * @param firstName
    *
    * @return the updated contact.
    */
   public Contact UpdateFirstName(String contactId, String firstName) {
      Contact contact = this.contacts.get(contactId);
      contact.setFirstName(firstName);

      return this.contacts.get(contactId);
   }

   /**
    * Update a contact's first name by it's id.
    * @param contactId the id of the contact we'd like to update.
    * @param lastName
    *
    * @return the updated contact.
    */
   public Contact UpdateLastName(String contactId, String lastName) {
      Contact contact = this.contacts.get(contactId);
      contact.setLastName(lastName);

      return this.contacts.get(contactId);
   }

   /**
    * Update a contact's first name by it's id.
    * @param contactId the id of the contact we'd like to update.
    * @param number
    *
    * @return the updated contact.
    */
   public Contact UpdateNumber(String contactId, String number) {
      Contact contact = this.contacts.get(contactId);
      contact.setNumber(number);

      return this.contacts.get(contactId);
   }

   /**
    * Update a contact's first name by it's id.
    * @param contactId the id of the contact we'd like to update.
    * @param address
    *
    * @return the updated contact.
    */
   public Contact UpdateAddress(String contactId, String address) {
      Contact contact = this.contacts.get(contactId);
      contact.setAddress(address);

      return this.contacts.get(contactId);
   }

   /**
    * Get the number of items in the datastore.
    * @return
    */
   public int Count() {
      return this.contacts.size();
   }
}
