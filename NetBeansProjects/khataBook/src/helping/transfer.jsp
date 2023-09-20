<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Project Management</title>
        <link rel="stylesheet" href="project.css">

        <style>
            h2 {
                font-family: Arial;
                font-size: 25px;
                font-style: normal;
                font-weight: bold;
                color: black;
                text-align: center;
                text-decoration: underline;
            }
            table {
                background-color: rgb(107, 250, 243);
                font-size: 18px;
                font-weight: bold;
                font-family: Arial, Helvetica, sans-serif;
                border-radius: 4px;
            }
            input[type=text] {
                box-sizing: border-box;
                width: 80%;
                padding: 10px 5px;
                margin-top: 15px;
                margin-right: 15px;
                border-radius: 5px;
            }
            input[type=date] {
                box-sizing: border-box;
                width: 80%;
                margin: 8px 0;
                padding: 8px 5px;
                border-radius: 5px;
            }
            select {
                box-sizing: border-box;
                width: 80%;
                margin: 8px 0;
                padding: 10px 5px;
                border-radius: 5px;
            }
            textarea {
                padding: 2px;
                line-height: 1;
                border-radius: 5px;
                box-sizing: border-box;
            }
            .reset1 {
                width: 30%;
                background-color: #547ef3;
                color: white;
                padding: 12px 8px;
                margin-right: 50px;
                margin-left: -50px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 15px;

                margin-top: auto;
            }
            .reset2:hover{
                background-color: #584ca0;
            }
            button[type=submit] {
                width: 65%;
                padding: 12px 8px;
                margin-left: 80px;
                margin-top: auto;
                /* margin-bottom: 20px; */
                margin-right: -20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                background-color: #33d439;
                color: white;
                font-size: 15px;
            }

            button[type=submit]:hover {
                background-color: #45a049;
            }
            .row1{
                visibility: hidden;
                display: none;
            }
            .reset2{
                visibility: hidden;
                display: none;
            }
        </style>
    </head>
    <body>
        <h2>Product Detail</h2>
        <table cellpadding="10" cellspacing="2" align="center">
            <th class="row1">Product Name</th>
            <tr>
                <td class="col1">Project Name</td>
                <td class="col2"><input type="text" name="project name" id="PName" placeholder="project name"></td>
            </tr>
            <th class="row1">Assigned to</th>
            <tr>
                <td class="col1">Assigned to</td>
                <td class="col2">
                    <select name="person" id="projectAssigned">
                        <option value="Er Merry Petision">Er Merry Petision</option>
                        <option value="Er Deepak Bhusan">Er Deepak Bhusan</option>
                        <option value="Er Robert Watson">Er Robert Watson</option>
                    </select>
                </td>
            </tr>

            <th class="row1">Start Date</th>
            <tr>
                <td class="col1">Start Date</td>
                <td class="col2"><input type="date" name="Start Date" id="SDate" class="startDate"></td>
            </tr>
            <th class="row1">End Date</th>
            <tr>
                <td class="col1">End Date</td>
                <td class="col2"><input type="date" name="End date" id="EDate" class="endDate"></td>
            </tr>

            <th class="row1">Priority</th>
            <tr>
                <td class="col1">Priority</td>
                <td class="col2">
                    <input type="radio" name="priority" id="high" value="High"> High
                    <input type="radio" name="priority" id="average" value="Average"> Average
                    <input type="radio" name="priority" id="low" value="Low"> Low
                </td>
            </tr>
            <th class="row1">Description</th>
            <tr>
                <td class="col1">Description</td>
                <td class="col2"><textarea name="description" id="description" cols="35" rows="4"></textarea></td>
            </tr>
            <tr colspan="2" align="center">
                <td>
                    <button type="submit" class="submit1"  onclick="submitProjectDetails()">Submit</button>
                </td>
                <td>
                    <button type="reset" class="reset1" onclick="resetProjectDetails()">Clear</button>
                </td>
            </tr>
            <tr colspan="1" align="center">
                <td>
                    <button type="reset" class="reset2" onclick="resetProjectDetails()">Clear</button>
                </td>
            </tr>
        </table>
        <script src="project.js"></script>
    </body>

</html>