# Linux/Mac
| Command Name                         | Command                    |
|--------------------------------------|----------------------------|
| View hidden files in finder          | `Cmd+Shift+.`              |
| Export to path                       | ``                         |
| Echo                                 | `echo $PATH`               |
| Changes the directory to your folder | `cd <path-to-your-folder>` |
|Screenshot| Shft+Ctrl+Cmd+4|


### Export PATH
    Open file zshrc in nano/vi editors and Export path
    nano ~/.zshrc
    export PATH="/usr/local/bin:$PATH"

    Control + O (^O): Save the file
    Control + X (^X): Exit the editor
    Control + K (^K): Cut a line
    Control + U (^U): Paste a line
    Control + W (^W): Search text

    vi ~/.zshrc
    export PATH="/usr/local/bin:$PATH"
    i: Enter insert mode to start typing
    Esc: Exit insert mode and return to command mode
    :w: Write (save) the file
    :q: Quit the editor
    :wq: Save and quit
    :q!: Quit without saving
    /text: Search for "text"
    dd: Delete a line

## Copy folders in mac
    cp -R </path/to/source/folder/> </path/to/destination/>
    mv e2e tests-examples playwright.config.js playwright-demo/
    Ctrl+C to quit

### Clear console
    clear
    Cmd+K
    Ctrl+L
### current directory path
    pwd

### Install Homebrew
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
    brew update
### Install oh-zsh
    sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
    git clone https://github.com/zsh-users/zsh-autosuggestions ~/.oh-my-zsh/custom/plugins/zsh-autosuggestions
    plugins=(git zsh-autosuggestions)
    omz --version

ps aux | grep '[c]hromedriver' | awk '{print $2}' | xargs kill -9

1. File and Directory Management
   ls: List files and directories.
   ls -l: Detailed listing with permissions.
   ls -a: Include hidden files.
   cd: Change directory.
   cd /path/to/directory
   pwd: Print the current working directory.
   mkdir: Create directories.
   mkdir new_folder
   rm: Remove files or directories.
   rm file.txt: Remove a file.
   rm -r folder: Remove a directory recursively.
   cp: Copy files or directories.
   cp source.txt destination.txt
   mv: Move or rename files.
   mv old_name.txt new_name.txt
   touch: Create an empty file.
   touch new_file.txt
2. File Content and Viewing
   cat: View the content of a file.
   cat file.txt
   less: View file content page by page.
   less large_file.txt
   tail: View the last few lines of a file.
   tail -n 10 log.txt
   head: View the first few lines of a file.
   head -n 5 file.txt
   nano / vim: Open files for editing in a terminal-based editor.
   nano file.txt
   vim file.txt
3. Process and System Monitoring
   ps: List running processes.
   ps aux: Detailed process listing.
   top: Monitor system resource usage in real-time.
   htop: Enhanced version of top (if installed).
   kill: Terminate a process.
   kill -9 PID
   df: Show disk space usage.
   df -h: Human-readable format.
   du: Check the size of a directory or file.
   du -sh folder/
   free: Show memory usage.
   free -m: In megabytes.
4. Networking
   ping: Check connectivity to a host.
   ping google.com
   curl: Make HTTP requests.
   curl -X GET https://api.example.com
   wget: Download files from the internet.
   wget https://example.com/file.zip
   netstat / ss: Check open ports and network connections.
   netstat -tuln or ss -tuln
   ifconfig / ip addr: Check network interface configurations.
5. User and Permissions
   whoami: Show the current logged-in user.
   sudo: Run commands with elevated privileges.
   sudo apt-get update
   chmod: Change file permissions.
   chmod 755 file.sh
   chown: Change file ownership.
   chown user:group file.txt
   passwd: Change the user password.
6. Compression and Archiving
   tar: Archive files.
   tar -cvf archive.tar files/
   tar -xvf archive.tar: Extract files.
   zip / unzip: Compress and decompress files.
   zip archive.zip file.txt
   unzip archive.zip
7. Search and Filters
   grep: Search for text in files.
   grep "error" log.txt
   find: Search for files and directories.
   find / -name file.txt
   awk / sed: Process text and files.
   awk '{print $1}' file.txt: Print the first column.
   sed 's/old/new/g' file.txt: Replace text.
8. System Updates and Software
   apt-get / yum: Install and manage packages.
   sudo apt-get install package_name
   sudo yum update
   dpkg / rpm: Work with package files.
   dpkg -i package.deb
   rpm -ivh package.rpm
9. Automation and Scripting
   bash: Run shell scripts.
   bash script.sh
   crontab: Schedule tasks.
   crontab -e: Edit cron jobs.
