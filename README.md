## exaroton_plugin
An UNOFFICIAL plugin to provide useful commands to servers hosting with exaroton.

### Installation
1. Stop your server.
2. Place the plugin jarfile from GitHub Releases into your server plugins folder.
3. Start your server, and open plugins/exaroton/config.yml
4. Set "token" to your exaroton API token, obtained on the [account page](https://exaroton.com/account)
5. Save the file and restart your server.

### Commands
```yaml
credits:
    description: "Check the amount of credits in the server owner's account"
port:
    description: "Get the current server port"
dynip:
    description: "Get the current server DynIP"
publishlog:
    description: "Publish your server log to mclo.gs and receive the link"
    permission: "exaroton.publishlog"
```
