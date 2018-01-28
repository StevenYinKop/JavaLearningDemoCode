package com.yinzifan.redmine;

import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taskadapter.redmineapi.CustomFieldManager;
import com.taskadapter.redmineapi.IssueManager;
import com.taskadapter.redmineapi.ProjectManager;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.UserManager;
import com.taskadapter.redmineapi.bean.CustomField;
import com.taskadapter.redmineapi.bean.CustomFieldDefinition;
import com.taskadapter.redmineapi.bean.Issue;
import com.taskadapter.redmineapi.bean.Project;
import com.taskadapter.redmineapi.bean.User;

/**
 * @author yinzf2 2018/01/16 15:10:37
 */
public class RedmineRESTDemo {
    public final static Logger LOGGER = LoggerFactory.getLogger(RedmineRESTDemo.class);
    private String projectKey = "yinzf2";
    private Integer queryId = null; // any
    private ProjectManager pm;
    private IssueManager im;
    private UserManager um;
    private CustomFieldManager fm;
    
    @Before
    public void setUp() {
        String uri = "http://localhost:3000";
        RedmineManager mgr = RedmineManagerFactory.createWithUserAuth(uri, "yinzf2", "11111111");
        pm = mgr.getProjectManager();
        im =  mgr.getIssueManager();
        um = mgr.getUserManager();
        fm = mgr.getCustomFieldManager();
    }
    
    @Test
    public void queryPrj() throws RedmineException {
        List<Project> projects = pm.getProjects();
        projects.forEach( x-> {
            LOGGER.info("getId: {} ", x.getId());
            LOGGER.info("getHomepage: {} ", x.getHomepage());
            LOGGER.info("getDescription: {} ", x.getDescription());
            LOGGER.info("getIdentifier: {} ", x.getIdentifier());
            LOGGER.info("getName: {} ", x.getName());
            LOGGER.info("getCreatedOn: {} ", x.getCreatedOn());
            Collection<CustomField> customFields = x.getCustomFields();
            for(CustomField customField : customFields) {
                LOGGER.info("customField-getName: {}", customField.getName());
                LOGGER.info("customField-getId: {}", customField.getId());
                LOGGER.info("customField-getValues: {}", customField.getValues());
            }
            LOGGER.info("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            
        });
    }
    
    @Test
    public void queryUser() throws RedmineException {
        List<User> users = um.getUsers();
        for(User user : users) {
            LOGGER.info("getStorage: {}",user.getStorage());
            LOGGER.info("getMail: {}",user.getMail());
            LOGGER.info("getGroup: {}",user.getGroups());
            LOGGER.info("getFirstName: {} , And getLastName: {}",user.getFirstName(), user.getLastName());
            Collection<CustomField> customFields = user.getCustomFields();
            for(CustomField customField: customFields) {
                LOGGER.info("customField.getId: {}",customField.getId());
                LOGGER.info("customField.getName: {}",customField.getName());
                LOGGER.info("customField.getValue: {}",customField.getValue());
                LOGGER.info("customField.getValues: {}",customField.getValues());
            }
            LOGGER.info("getCreatedOn: {}",user.getCreatedOn());
            LOGGER.info("getApiKey: {}",user.getApiKey());
            LOGGER.info("getLogin: {}",user.getLogin());
            LOGGER.info("getPassword: {}",user.getPassword());
            LOGGER.info("-------------------------------------------------------");
        }
    }
    @Test
    public void getCurrentUser() throws RedmineException {
        User currentUser = um.getCurrentUser();
        LOGGER.info("getStorage: {}",currentUser.getStorage());
        LOGGER.info("getMail: {}",currentUser.getMail());
        LOGGER.info("getGroup: {}",currentUser.getGroups());
        LOGGER.info("getFirstName: {} , And getLastName: {}",currentUser.getFirstName(), currentUser.getLastName());
        Collection<CustomField> customFields = currentUser.getCustomFields();
        for(CustomField customField: customFields) {
            LOGGER.info("customField.getId: {}",customField.getId());
            LOGGER.info("customField.getName: {}",customField.getName());
            LOGGER.info("customField.getValue: {}",customField.getValue());
            LOGGER.info("customField.getValues: {}",customField.getValues());
        }
        LOGGER.info("getCreatedOn: {}",currentUser.getCreatedOn());
        LOGGER.info("getApiKey: {}",currentUser.getApiKey());
        LOGGER.info("getLogin: {}",currentUser.getLogin());
        LOGGER.info("getPassword: {}",currentUser.getPassword());
        LOGGER.info("-------------------------------------------------------");
    }
    @Test
    public void setUser() throws RedmineException {
        User currentUser = um.getCurrentUser();
        currentUser.setMail("yinzf2@xxx.com"); // `email_addresses`
        um.update(currentUser);
    }    
    
    @Test
    public void createUser() throws RedmineException {
        User user = new User();
        user.setLogin("java");//用户名不能为空
        user.setPassword("11111111");
        user.setFirstName("Java");
        user.setLastName("CreateUser");
        user.setMail("java@java.com");
        um.createUser(user);
    }    
    
    @Test
    public void createIssue() throws RedmineException {
        List<CustomFieldDefinition> customFieldDefinitions = fm.getCustomFieldDefinitions();
        customFieldDefinitions.forEach(x-> {
            LOGGER.info(x.getId() + "");
            LOGGER.info(x.getName());
        });
    }    
    
    @Test
    public void changePrjName() throws RedmineException {
        List<Project> projects = pm.getProjects();
        for (Project project : projects) {
            System.out.println("project CreatedOn: " + project.getCreatedOn());
            System.out.println("project getId: " + project.getId());
            System.out.println("project getHomepage: " + project.getHomepage());
            System.out.println("project getName: " + project.getName());
            System.out.println("project getUpdatedOn: " + project.getUpdatedOn());
            System.out.println("project getIdentifier: " + project.getIdentifier());
        }
        List<Issue> issues = im.getIssues(projectKey, queryId);
        for (Issue issue : issues) {
            System.out.println(issue.toString());
        }
        Project project = pm.getProjectByKey(projectKey);
        
        project.setName("this is a project modified by yinzf2 by java API");
        
        pm.update(project);
        Project project2 = pm.getProjectByKey(projectKey);
        System.out.println("project getName: " + project2.getName());
    }
}
