package sda.mvn.bookstore.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import sda.mvn.bookstore.Book;
import sda.mvn.bookstore.Bookstore;

public class BookstoreSteps {

    private Bookstore bookstore;

    private Book book;

    @Given("^I instantiate a Bookstore$")
    public void I_instantiate_a_Bookstore() {
        bookstore = new Bookstore();
    }

    @And("^I create a Book$")
    public void I_create_a_Book() {
        book = new Book("The Lord of the Rings", 550, "J.R.R. Tolkien", "123456789");
    }

    @When("^I add the Book to the Bookstore$")
    public void I_add_the_Book_to_the_Bookstore() {
        bookstore.add(book);
    }

    @Then("^Book is present in the Bookstore$")
    public void Book_is_present_in_the_Bookstore() {
        Assert.assertEquals(1, bookstore.getBooks().size());
    }

    @Then("^Book author is JRR Tolkien$")
    public void bookAuthorIsJRRTolkien() {
        Assert.assertEquals("J.R.R. Tolkien", bookstore.getBooks().get(0).getAuthor());
    }

    @And("^I update title of the Book$")
    public void iUpdateTitleOfTheBook() {
        bookstore.updateTitle(book, "Silmarilion");
    }

    @Then("^Title of the book has changed$")
    public void titleOfTheBookHasChanged() {
        Assert.assertEquals("Silmarilion", bookstore.getBooks().get(0).getTitle());
    }
}
