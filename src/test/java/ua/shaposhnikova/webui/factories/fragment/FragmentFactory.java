package ua.shaposhnikova.webui.factories.fragment;

import ua.shaposhnikova.webui.factories.fragment.sections.BurgerMenuFragment;
import ua.shaposhnikova.webui.factories.fragment.sections.LoginFragment;
import ua.shaposhnikova.webui.factories.fragment.sections.admin.AdminManagementMenuFragment;
import ua.shaposhnikova.webui.factories.fragment.sections.admin.job_dropdown.job_titles.AddingJobTitleFragment;
import ua.shaposhnikova.webui.factories.fragment.sections.admin.job_dropdown.job_titles.JobTitlesFragment;

public interface FragmentFactory {

    AdminManagementMenuFragment getAdminManagementMenuFragment();

    AddingJobTitleFragment getAddingJobTitleFragment();

    JobTitlesFragment getJobTitlesFragment();

    LoginFragment getLoginFragment();

    BurgerMenuFragment getBurgerMenuFragment();




    void closeDriver();
}
