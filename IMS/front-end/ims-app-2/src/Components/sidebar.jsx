import * as React from "react";
import { styled, useTheme } from "@mui/material/styles";
import Box from "@mui/material/Box";
import MuiDrawer from "@mui/material/Drawer";
import MuiAppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import List from "@mui/material/List";
import CssBaseline from "@mui/material/CssBaseline";
import Typography from "@mui/material/Typography";
import Divider from "@mui/material/Divider";
import IconButton from "@mui/material/IconButton";
import MenuIcon from "@mui/icons-material/Menu";
import ChevronLeftIcon from "@mui/icons-material/ChevronLeft";
import ChevronRightIcon from "@mui/icons-material/ChevronRight";
import ListItem from "@mui/material/ListItem";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemText from "@mui/material/ListItemText";
import PersonSearchIcon from "@mui/icons-material/PersonSearch";
import LogoutIcon from "@mui/icons-material/Logout";

import { Avatar, Badge, Button, Collapse, Grid } from "@mui/material";

import { Route, Routes, useNavigate } from "react-router-dom";

import {
  AddShoppingCart,
  Home,
  ExpandLess,
  ExpandMore,
  ManageSearch,
  MonetizationOnSharp,
  PeopleAlt,
  Person,
  PersonAdd,
  RemoveShoppingCartSharp,
  ShoppingCartCheckoutSharp,
  ShoppingCartSharp,
} from "@mui/icons-material";
import AddBoxIcon from "@mui/icons-material/AddBox";
import { useState } from "react";
import { commonPath } from "../Routers/path";
import ViewAsset from "../Pages/viewAsset";
import AddAsset from "../Pages/addAssest";
import GridViewIcon from "@mui/icons-material/GridView";
// import InventoryAddForm from "../Pages/InventoryAddForm";
// // import SamplePage from "../Pages/SamplePage";
// import ViewAssets from "../Pages/ViewAssets";
// import BulkUploads from "../Pages/BulkUploads";

const drawerWidth = 150;
const openedMixin = (theme) => ({
  width: drawerWidth,
  transition: theme.transitions.create("width", {
    easing: theme.transitions.easing.sharp,
    duration: theme.transitions.duration.enteringScreen,
  }),
  overflowX: "hidden",
});
const closedMixin = (theme) => ({
  transition: theme.transitions.create("width", {
    easing: theme.transitions.easing.sharp,
    duration: theme.transitions.duration.leavingScreen,
  }),
  overflowX: "hidden",
  width: `calc(${theme.spacing(7)} + 1px)`,
  [theme.breakpoints.up("sm")]: {
    width: `calc(${theme.spacing(8)} + 1px)`,
  },
});
const DrawerHeader = styled("div")(({ theme }) => ({
  display: "flex",
  alignItems: "center",
  justifyContent: "flex-end",
  padding: theme.spacing(0),
  ...theme.mixins.toolbar,
}));

const AppBar = styled(MuiAppBar, {
  shouldForwardProp: (prop) => prop !== "open",
})(({ theme, open }) => ({
  zIndex: theme.zIndex.drawer + 1,
  transition: theme.transitions.create(["width", "margin"], {
    easing: theme.transitions.easing.sharp,
    duration: theme.transitions.duration.leavingScreen,
  }),
  ...(open && {
    marginLeft: drawerWidth,
    width: `calc(100% - ${drawerWidth}px)`,
    transition: theme.transitions.create(["width", "margin"], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  }),
}));
const Drawer = styled(MuiDrawer, {
  shouldForwardProp: (prop) => prop !== "open",
})(({ theme, open }) => ({
  width: drawerWidth,
  flexShrink: 0,
  whiteSpace: "nowrap",
  boxSizing: "border-box",
  ...(open && {
    ...openedMixin(theme),
    "& .MuiDrawer-paper": openedMixin(theme),
  }),
  ...(!open && {
    ...closedMixin(theme),
    "& .MuiDrawer-paper": closedMixin(theme),
  }),
}));
export default function Sidebar() {
  const theme = useTheme();
  const [open, setOpen] = React.useState(false);
  const [menuOpen, setMenuOpen] = React.useState(false);

  const handleDrawerOpen = () => {
    setOpen(true);
  };
  const navigate = useNavigate();

  const handleDrawerClose = () => {
    setOpen(false);
  };
  return (
    <Box sx={{ display: "flex" }}>
      <CssBaseline />
      <AppBar position="fixed" open={open}>
        <Toolbar>
          <IconButton
            onClick={handleDrawerOpen}
            edge="start"
            sx={{
              marginRight: 4,
              ...(open && { display: "none" }),
            }}
          >
            <MenuIcon sx={{ color: "white" }} />
          </IconButton>
          <Typography variant="h5">Inventory Management System</Typography>
        </Toolbar>
      </AppBar>
      <Drawer variant="permanent" open={open}>
        <DrawerHeader>
          <IconButton onClick={handleDrawerClose}>
            {theme.direction === "rtl" ? (
              <ChevronRightIcon sx={{ color: "white" }} />
            ) : (
              <ChevronLeftIcon sx={{ color: "white" }} />
            )}
          </IconButton>
        </DrawerHeader>
        <Divider />

        <List>
          <ListItem
            disablePadding
            onClick={() => {
              navigate(commonPath?.viewAsset);
            }}
          >
            <ListItemButton
              sx={{
                justifycontent: open ? "initial" : "center",
              }}
            >
              <GridViewIcon
                sx={{
                  mr: open ? 1 : "auto",
                }}
              />
              <ListItemText sx={{ opacity: open ? 1 : 0, fontSize: "30px" }}>
                View Assets
              </ListItemText>
            </ListItemButton>
          </ListItem>
          <ListItem
            disablePadding
            onClick={() => {
              navigate(commonPath?.addAsset);
            }}
          >
            <ListItemButton>
              <AddBoxIcon
                sx={{
                  mr: open ? 1 : "auto",
                }}
              />
              <ListItemText sx={{ opacity: open ? 1 : 0 }}>
                Add Assets
              </ListItemText>
            </ListItemButton>
          </ListItem>
        </List>
      </Drawer>

      <Box component="main" sx={{ flexGrow: 1, pt: 8 }}>
        <Routes>
          <Route path={commonPath?.viewAsset} element={<ViewAsset />} />
          <Route path={commonPath?.addAsset} element={<AddAsset />} />
        </Routes>
      </Box>
    </Box>
  );
}
