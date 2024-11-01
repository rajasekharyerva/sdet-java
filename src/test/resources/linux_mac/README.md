# Linux/Mac
| Command Name                         | Command                    |
|--------------------------------------|----------------------------|
| View hidden files in finder          | `Cmd+Shift+.`              |
| Export to path                       | ``                         |
| Echo                                 | `echo $PATH`               |
| Changes the directory to your folder | `cd <path-to-your-folder>` |


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