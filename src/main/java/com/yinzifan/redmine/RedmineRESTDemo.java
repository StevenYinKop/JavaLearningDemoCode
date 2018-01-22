package com.yinzifan.redmine;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taskadapter.redmineapi.ProjectManager;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.bean.Issue;
import com.taskadapter.redmineapi.bean.Project;

/**
 * @author yinzf2 2018/01/16 15:10:37
 */
public class RedmineRESTDemo {
    public final static Logger logger = LoggerFactory.getLogger(RedmineRESTDemo.class);
    
    public static void foo() throws RedmineException {
        String uri = "http://localhost:3000";
        String projectKey = "yinzf2";
        Integer queryId = null; // any
        
        RedmineManager mgr = RedmineManagerFactory.createWithUserAuth(uri, "yinzf2", "11111111");
        ProjectManager pm = mgr.getProjectManager();
        
        List<Project> projects = pm.getProjects();
        for (Project project : projects) {
            System.out.println("project CreatedOn: " + project.getCreatedOn());
            System.out.println("project getId: " + project.getId());
            System.out.println("project getHomepage: " + project.getHomepage());
            System.out.println("project getName: " + project.getName());
            System.out.println("project getUpdatedOn: " + project.getUpdatedOn());
            System.out.println("project getIdentifier: " + project.getIdentifier());
        }
        List<Issue> issues = mgr.getIssueManager().getIssues(projectKey, queryId);
        for (Issue issue : issues) {
            System.out.println(issue.toString());
        }
        Project project = pm.getProjectByKey(projectKey);
        
        project.setName("this is a project modified by yinzf2 by java API");
        
        pm.update(project);
        Project project2 = pm.getProjectByKey(projectKey);
        System.out.println("project getName: " + project2.getName());
    }
    
    public static void main(String[] args) throws RedmineException {
        RedmineRESTDemo.foo();
    }
}
