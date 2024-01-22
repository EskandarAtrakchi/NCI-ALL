markdown
# Running Linux on Windows 10

## Windows Subsystem for Linux (WSL)

WSL allows you to run a Linux distribution alongside your Windows installation without the need for dual-booting.

To enable WSL, open PowerShell as Administrator and run:

```powershell
dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart
```

Then, enable Virtual Machine Platform:

```powershell
dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart
```

Restart your computer.

Install a Linux distribution from the Microsoft Store (e.g., Ubuntu, Debian, Fedora).
```