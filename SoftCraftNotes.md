# softcraft01
SoftCraft
updated001


git config --global user.name "Your Name"
git config --global user.email "your_email@example.com"

git init
git remote add origin https://github.com/imam-nadaf/softcraft01
git clone https://github.com/imam-nadaf/softcraft01
cd C:\Users\imam\softcraft01
git add README.md
git commit -m "Add README.md"
git push -u origin main
git pull origin main
softcraft02

git init [initialize empty git repository on local without adding any remote]

git add [add a file/folder from working directory to staging area]

git commit -m "message" [save the current state as snapshot]

git push [pushes local changes to repository/server/host] (check in)

git pull [download the changes from repository/server/host]

git branch feature-A [create a new branch with given name]

git checkout feature-A [checkout to newly created branch] (git checkout -b feature-A)

git merge main [merge all the changes from branch main and feature-A]

git rebase main [rebase or put my commits on top of commits of branch main]

git status [shows status of all the files (working dir/staging area)]

# softcraft02:
Maven is a build automation and project management tool for Java.

Advantages:

Easy dependency management: Automatically downloads required libraries.

Standardized builds: Consistent process for all Maven projects.

Organized project structure: Enforces a clear directory layout.

Extensive plugin support: Many tools available for various tasks.

Central repository: Access to a vast library of open-source components.


# softcraft04
Build Lifecycle

validate -> resource -> compile -> test -> package -> deploy
              1. main resource  1. main class
              2. test resources  2. test classes

validate pom.xml, copy main resources, compile main java, copy test resource, compile test java, run test, jar, install, deploy

maven frequently used commands
1. mvn clean compile --> cleans the target folder and recompile everything
2. mvn clean compile -DskipTests --> cleans the target folder and recompile main classes excluding test
3. mvn clean compile -U --> clean compile, force download dependenciˀes
4. mcn dependency:tree --> list down dependencies as a tree depicting transient dependencies
