for start grid hub and grid nodes, use .bat files in "src\test\resources\grid_tools\"
for change hub connection settings, use "src\test\resources\config.properties"
for change user settings - use file "src\test\resources\user.properties"
for change letters - user files "src\test\resources\Informal_letter.properties" and "src\test\resources\Formal_letter.properties"

For start tests - use "srs\test\java\com\epam\pave_loginov\patterns\runner.xml":
	It conteins following parameters:
	- browser. It can take values "firefox", "chrome", "opera"
	- letterType. It can take values "formal" and "informal" 
Using different combinations of these parameters you can start that browser is what necessary to you and creation formal or informal letters which will be use in tests.