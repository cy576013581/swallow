@IF EXIST "%~dp0\node.exe" (
  "%~dp0\node.exe"  "%~dp0\..\yuicompressor\nodejs\cli.js" %*
) ELSE (
  node  "%~dp0\..\yuicompressor\nodejs\cli.js" %*
)