package com.example.lab5.ProjectTrackerSystem.Controller;

import com.example.lab5.Api.ApiResponse;
import com.example.lab5.ProjectTrackerSystem.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/project")
public class ProjectController {

    ArrayList<Project> projects = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Project> getProjects() {
        return projects;
    }

    @PostMapping("/add")
    public ApiResponse addProject(@RequestBody Project project) {
        projects.add(project);
        return new ApiResponse("Project added");
    }

    @PutMapping("/update/{id}")
    public ApiResponse updateProject(@PathVariable String id, @RequestBody Project project) {
        for (Project p : projects) {
            if (p.getId().equals(id)) {
                projects.set(projects.indexOf(p), project);
                return new ApiResponse("Project updated");
            }
        }
        return new ApiResponse("Project not found");
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteProject(@PathVariable String id) {
        for (Project p : projects) {
            if (p.getId().equals(id)) {
                projects.remove(p);
                return new ApiResponse("Project deleted");
            }
        }
        return new ApiResponse("Project not found");
    }

    @PutMapping("/change/status/{id}")
    public ApiResponse changeStatus(@PathVariable String id) {
        for (Project p : projects) {
            if (p.getId().equals(id)) {
                if (!p.getStatus().equalsIgnoreCase("done")) {
                    p.setStatus("Done");
                    return new ApiResponse("Project status changed to Done");
                }
            }
        }
        return new ApiResponse("Project status not changed");
    }

    @GetMapping("/search/{title}")
    public Project searchProjectByTitle(@PathVariable String title) {
        for (Project p : projects) {
            if (p.getTitle().equalsIgnoreCase(title))
                return p;
        }
        return null;
    }

    @GetMapping("/get/{companyName}")
    public ArrayList<Project> getProjectsByCompany(@PathVariable String companyName) {
        ArrayList<Project> projectsByCompany = new ArrayList<>();
        for (Project p : projects) {
            if (p.getCompanyName().equalsIgnoreCase(companyName))
                projectsByCompany.add(p);
        }
        return projectsByCompany;
    }
}
