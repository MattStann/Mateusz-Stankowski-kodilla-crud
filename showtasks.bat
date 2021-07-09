call runcrud.bat
if "%ERRORLEVEL%" == "0" goto runwebbrowser
echo.
echo runcrud.bat has errors - breaking work
goto fail

:runwebbrowser
start chrome http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo chrome doesn't want to open
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished