package ua.shaposhnikova.webui.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import ua.shaposhnikova.webui.factories.fragment.FragmentFactory;
import ua.shaposhnikova.webui.factories.fragment.PageFactoryHolder;
import ua.shaposhnikova.webui.factories.fragment.sections.admin.job_dropdown.job_titles.AddingJobTitleFragment;

@Slf4j
public class StepsImpl {
    private final FragmentFactory fragmentFactory;
    public StepsImpl(){
        fragmentFactory = PageFactoryHolder.getImpl1InstanceWithEdgeDriver();
    }

    @Given("Alicia, site user, navigates to the login page")
    public void enterLoginPage() {
        fragmentFactory.getLoginFragment().redirectToLoginPage();
    }

    @When("Alicia logs in")
    public void logIn() {
        fragmentFactory.getLoginFragment().loginWithGivenTips();
    }

    @When("Alicia gains access to the Admin page")
    public void loadAdmin() {
        fragmentFactory.getBurgerMenuFragment().clickOnAdminOption();
    }

    @And("Alicia selects the 'Job' dropdown from the menu")
    public void getJobTitlesPage() {
        fragmentFactory.getAdminManagementMenuFragment().clickOnJobDropdown();
    }

    @And("Alicia chooses the 'Job titles' option")
    public void selectJobTitles(){
        fragmentFactory.getAdminManagementMenuFragment().clickOnJobTitlesOption();
    }

    @And("Alicia clicks on the Add button")
    public void getAddJobTitlePage() {
        fragmentFactory.getJobTitlesFragment().clickOnAddJobTitleButton();
    }

    @And("Alicia provides the necessary details, such as the title, description, and note, to create a new job title and saves the changes")
    public void addJobTitle(String jobTitle, String description, String note) {
        AddingJobTitleFragment addingJobTitleFragment = fragmentFactory.getAddingJobTitleFragment();
        addingJobTitleFragment.injectData(jobTitle, description, note);
        addingJobTitleFragment.saveJobTitle();
    }


    @Then("Alicia expects the newly added job title to be visible on the 'Job Titles' page")
    public void verifyNewJobTitleCreation(String jobTitle) {
        fragmentFactory.getJobTitlesFragment().assertNewJobTitleHasBeenAdded(jobTitle);
    }

    @When("Alicia selects the previously added job title from the list")
    public void selectJobTitle(String jobTitle) {
        fragmentFactory.getJobTitlesFragment().selectJobTitle(jobTitle);
    }

    @And("Alicia clicks on the 'Delete selected' button")
    public void deleteSelectedTitles(){
        fragmentFactory.getJobTitlesFragment().clickOnDeleteSelectedButton();
    }

    @And("Alicia confirms the deletion by dedicatedclicking 'Yes, Delete'")
    public void confirmDeletion() {
        fragmentFactory.getJobTitlesFragment().clickOnYesDeleteButton();
    }

    @Then("Alicia confirms that the job title has been successfully removed and is no longer displayed on the 'Job Titles' page")
    public void verifyJobTitleDeletion(String jobTitle) {
        fragmentFactory.getJobTitlesFragment().assertJobTitleDeleted(jobTitle);
    }

    @After
    public void closeBrowser() {
        log.info("Closing browser...");
        fragmentFactory.closeDriver();
        log.info("Browser is closed");
    }
}
