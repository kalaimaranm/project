import {
  FormControl,
  Grid,
  IconButton,
  InputLabel,
  Menu,
  Select,
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow,
  Typography,
} from "@mui/material";
import React, { useState } from "react";
import MoreVertIcon from "@mui/icons-material/MoreVert";
import MenuItem from "@mui/material/MenuItem";
import MenuList from "@mui/material/MenuList";
const options = ["view", "Edit"];
const status = ["Avaliable", "Out Of Stock", "In Use"];

const rows = [
  {
    serial_no: "001",
    pro_name: "Laptop",
    category: "Electronics",
    Brand: "Lenova",
    price: "1,00,000",
    Supplier_Name: "Vinoth",
    Status: "Avaliable",
    Assigned_to: "Vinothini",
  },
  {
    serial_no: "002",
    pro_name: "Chair",
    category: "Furniture",
    Brand: "Penthoom",
    price: "1,000",
    Supplier_Name: "Vinoth",
    Status: "Out Of Stock",
    Assigned_to: "Raji",
  },
  {
    serial_no: "003",
    pro_name: "Laptop",
    category: "Electronics",
    Brand: "Dell",
    price: "75,000",
    Supplier_Name: "Vinoth",
    Status: "Avaliable",
    Assigned_to: "Rubica",
  },
  {
    serial_no: "004",
    pro_name: "Tv",
    category: "Electronics",
    Brand: "Samsung",
    price: "1,50,000",
    Supplier_Name: "Vinoth",
    Status: "Avaliable",
    Assigned_to: "Ravi",
  },
  {
    serial_no: "005",
    pro_name: "Projector",
    category: "Electronics",
    Brand: "Zebronics",
    price: "25,000",
    Supplier_Name: "Vinoth",
    Status: "Avaliable",
    Assigned_to: "Kannan",
  },
  {
    serial_no: "006",
    pro_name: "Speaker",
    category: "Electronics",
    Brand: "Zebronics",
    price: "12,000",
    Supplier_Name: "Vinoth",
    Status: "Avaliable",
    Assigned_to: null,
  },
  {
    serial_no: "007",
    pro_name: "WhiteBoard",
    category: "Stationary",
    Brand: "Craftwaft",
    price: "750",
    Supplier_Name: "Vinoth",
    Status: "Out Of Stock",
    Assigned_to: null,
  },
  {
    serial_no: "008",
    pro_name: "Computer",
    category: "Electronics",
    Brand: "Hp",
    price: "1,00,000",
    Supplier_Name: "vinoth",
    Status: "Out Of Stock",
    Assigned_to: "Vicky",
  },
];

export default function ViewAset() {
  const [anchorEl, setAnchorEl] = useState(null);
  const open = Boolean(anchorEl);
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };
  const initialStatusUpdate = {};
  rows.forEach((row, index) => {
    initialStatusUpdate[index] = row.Status;
  });
  const [statusUpdate, setStatusUpdate] = useState(initialStatusUpdate);

  const handleStatusChange = (index, newValue) => {
    setStatusUpdate((prevStatus) => ({
      ...prevStatus,
      [index]: newValue,
    }));
  };

  // const handleStatusChange = (event) => {
  //   setStatusUpdate(event.target.value);
  // };
  return (
    <Grid container p={3}>
      <Grid item display={"flex"} justifyContent={"center"}>
        <Typography variant="h4">View Assets</Typography>
      </Grid>

      <Table>
        <TableHead sx={{ backgroundColor: "#64B6F7" }}>
          <TableRow >
            <TableCell >Serial_no</TableCell>
            <TableCell >Name_of_the_Asset</TableCell>
            <TableCell >Category</TableCell>
            <TableCell >Brand</TableCell>
            {/* <TableCell >Price</TableCell> */}
            <TableCell >Supplier_Name</TableCell>
            {/* <TableCell>Ssx={{color:"white"}}Stock_Quantity</TableCell> */}
            <TableCell >Status</TableCell>
            <TableCell >Assigned_to</TableCell>
            <TableCell >Action_Button</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((item, index) => (
            <TableRow
              key={item.id}
              sx={{ backgroundColor: index % 2 == 0 ? "#f5f5f5" : "white" }}
            >
              <TableCell>{item.serial_no}</TableCell>
              <TableCell>{item.pro_name}</TableCell>
              <TableCell>{item.category}</TableCell>
              <TableCell>{item.Brand}</TableCell>
              {/* <TableCell>{item.price}</TableCell> */}
              <TableCell>{item.Supplier_Name}</TableCell>
              {/* <TableCell>{item.Stock_Quantity}</TableCell> */}
              <TableCell>
                <FormControl>
                  {/* <InputLabel id="demo-simple-select-label">status</InputLabel> */}
                  <Select
                    size="small"
                    value={ statusUpdate[index]|| item.Status }
                    onChange={(e) => {
                      handleStatusChange(index, e.target.value);
                    }}
                    fullWidth
                  >
                    {status.map((option, ind) => (
                      <MenuItem key={ind} value={option}>
                        {option}
                      </MenuItem>
                    ))}
                  </Select>
                </FormControl>
              </TableCell>
              <TableCell>{item.Assigned_to ? item.Assigned_to : "-"}</TableCell>
              <TableCell>
                <IconButton size="small" onClick={handleClick}>
                  <MoreVertIcon fontSize="20px" />
                </IconButton>
                <Menu anchorEl={anchorEl} open={open} onClose={handleClose}>
                  {options.map((option) => (
                    <MenuItem key={option} onClick={handleClose}>
                      {option}
                    </MenuItem>
                  ))}
                </Menu>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </Grid>
  );
}
