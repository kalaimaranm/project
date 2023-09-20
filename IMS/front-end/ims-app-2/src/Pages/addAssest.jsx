// import {
//   Box,
//   Grid,
//   Typography,
//   TextField,
//   InputLabel,
//   Select,
//   MenuItem,
//   Button,
//   Input,
//   Hidden,
//   Dialog,
//   DialogTitle,
//   DialogContent,
//   DialogContentText,
//   DialogActions,
// } from "@mui/material";
// import axios from "axios";

// import * as React from "react";
// import { useState } from "react";
// import { useForm } from "react-hook-form";
// import { ApiRequest } from "../Utils/apiRequest";

// export default function AddAsset() {
//   const [isDialogOpen, setIsDialogOpen] = useState(false);
//   const categories = [
//     {
//       categoryId: "B",
//       categoryName: "Laptop",
//       specifications: [
//         { name: "ram", label: "RAM" },
//         { name: "size", label: "Size" },
//         { name: "processor", label: "Processor" },
//         { name: "graphicsCard", label: "Graphics Card" },
//         { name: "brand", label: "Brand" },
//       ],
//     },
//     {
//       categoryId: "C",
//       categoryName: "Furniture",
//       specifications: [
//         { name: "chairType", label: "Chair Type" },
//         { name: "company", label: "Company" },
//         { name: "height", label: "Height" },
//       ],
//     },
//     {
//       categoryId: "D",
//       categoryName: "Server",
//       specifications: [
//         { name: "processor", label: "Processor" },
//         { name: "memory", label: "RAM" },

//         { name: "display", label: "Display" },
//         { name: "port", label: "Port" },
//       ],
//     },
//   ];

//   const {
//     register,
//     handleSubmit,
//     watch,
//     formState: { errors },
//   } = useForm({});
//   const selectedCategory = watch("category");

//   const onSubmit = (data) => {
//     console.log(data);
//   };

//   const [open, setOpen] = useState(false);
//   const [file, setFile] = useState(null);

//   const handleOpen = () => {
//     setOpen(true);
//   };
//   const handleClose = () => {
//     setOpen(false);
//     setFile(null);
//   };
//   const handleFileChange = (e) => {
//     setFile(e.target.files[0]);
//   };
//   const handleUpload = () => {
//     const formData = new FormData();
//     formData.append("file", file);
//     let result = ApiRequest(
//       "https://cc3e-49-207-182-199.ngrok-free.app/upload",
//       "POST",
//       formData,
//       true
//     );
//     console.log(result, "resulttttt");
//     // axios
//     //   .post("https://cc3e-49-207-182-199.ngrok-free.app/upload", formData, {
//     //     headers: {
//     //       "Content-Type": "multipart/form-data",
//     //     },
//     //   })
//     //   .then((response) => {
//     //     console.log("Upload successful-------", response.data);
//     //   })
//     //   .catch((error) => {
//     //     console.error("Error uploading file:", error);
//     //   });
//   };
//   return (
//     <Box display={"flex"} justifyContent={"center"}>
//       <Grid
//         container
//         lg={10}
//         mt={2}
//         border={1}
//         display="flex"
//         justifyContent={"center"}
//       >
//         <Grid
//           item
//           lg={8}
//           mt={5}
//           display={"flex"}
//           flexDirection={"row"}
//           justifyContent={"space-between"}
//         >
//           <Grid container lg={12}>
//             <Grid item lg={8}>
//               <Typography sx={{ ml: 6 }} variant={"h5"}>
//                 Inventory Add Form
//               </Typography>
//             </Grid>
//             <Grid item lg={3} display={"flex"} justifyContent={"end"}>
//               <Button
//                 sx={{ ml: 3 }}
//                 variant="contained"
//                 color="primary"
//                 onClick={handleOpen}
//               >
//                 File Upload
//               </Button>
//             </Grid>
//           </Grid>

//           <Dialog open={open} onClose={handleClose}>
//             <DialogTitle>Upload a File</DialogTitle>
//             <DialogContent>
//               <DialogContentText>
//                 Please select a file to upload.
//               </DialogContentText>
//               <TextField
//                 type="file"
//                 accept=".xlsx"
//                 onChange={handleFileChange}
//               />
//             </DialogContent>
//             <DialogActions>
//               <Button onClick={handleClose} color="primary">
//                 Cancel
//               </Button>
//               <Button onClick={handleUpload} color="primary" disabled={!file}>
//                 Upload
//               </Button>
//             </DialogActions>
//           </Dialog>
//         </Grid>

//         <Grid item mt={2} lg={8} p={2}>
//           <form onSubmit={handleSubmit(onSubmit)}>
//             <Grid
//               item
//               lg={12}
//               display={"flex"}
//               justifyContent={"space-evenly"}
//               flexDirection={"row"}
//             >
//               <Grid item lg={3}>
//                 <InputLabel sx={{ p: 1 }} htmlFor="productName">
//                   Name Of Asset
//                 </InputLabel>
//               </Grid>
//               <Grid item lg={8}>
//                 <TextField
//                   fullWidth
//                   {...register("productName")}
//                   label="Product Name"
//                   size="small"
//                   error={errors.productName}
//                   helperText={errors.productName && "name is required"}
//                 />
//               </Grid>
//             </Grid>

//             <Grid
//               item
//               lg={12}
//               mt={4}
//               display={"flex"}
//               justifyContent={"space-evenly"}
//               flexDirection={"row"}
//             >
//               <Grid item lg={3}>
//                 <InputLabel sx={{ p: 1 }} htmlFor="description">
//                   Description:
//                 </InputLabel>
//               </Grid>
//               <Grid item lg={8}>
//                 <TextField
//                   sx={{}}
//                   {...register("description")}
//                   label="Description"
//                   size="small"
//                   fullWidth
//                   error={errors.description}
//                   helperText={errors.description && "Enter must"}
//                 />
//               </Grid>
//             </Grid>

//             <Grid
//               item
//               lg={12}
//               mt={4}
//               display={"flex"}
//               justifyContent={"space-evenly"}
//               flexDirection={"row"}
//             >
//               <Grid item lg={3}>
//                 <InputLabel sx={{ p: 1 }} htmlFor="category">
//                   Category Type:
//                 </InputLabel>
//               </Grid>
//               <Grid item lg={8}>
//                 <Select
//                   fullWidth
//                   size="small"
//                   sx={{}}
//                   defaultValue=" "
//                   {...register("category")}
//                   error={errors.category}
//                 >
//                   <MenuItem value=" ">---Select---</MenuItem>
//                   {categories.map((category) => (
//                     <MenuItem
//                       key={category.categoryId}
//                       value={category.categoryId}
//                     >
//                       {category.categoryName}
//                     </MenuItem>
//                   ))}
//                 </Select>
//               </Grid>
//             </Grid>

//             <Grid
//               item
//               lg={12}
//               mt={4}
//               display={"flex"}
//               flexDirection={"row"}
//               justifyContent={"space-evenly"}
//             >
//               {selectedCategory && selectedCategory !== " " ? (
//                 <>
//                   <Grid item lg={3}>
//                     <InputLabel sx={{ p: 1 }}>Specifications:</InputLabel>
//                   </Grid>

//                   <Grid
//                     item
//                     lg={8}
//                     display={"flex"}
//                     flexDirection={"row"}
//                     flexWrap={"revert"}
//                   >
//                     {categories
//                       .find(
//                         (category) => category.categoryId === selectedCategory
//                       )
//                       ?.specifications.map((specification) => (
//                         <TextField
//                           {...register(`specifications.${specification.name}`)}
//                           size="small"
//                           label={specification.label}
//                         />
//                       ))}
//                   </Grid>
//                 </>
//               ) : null}
//             </Grid>
//             {/* <Grid item   lg={12} display={"flex"} flexDirection={"row"} justifyContent={"space-evenly"} >

//                             <Grid item  lg={3} >
//                                 <InputLabel sx={{ p: 1 }} htmlFor="quantity">Quantity:</InputLabel>
//                             </Grid>

//                             <Grid item lg={8}>
//                                 <TextField sx={{ }}
//                                     {...register("quantity",)}
//                                     label="Qty"
//                                     type="number"
//                                     size="small"
//                                     error={errors.quantity}
//                                     helperText={errors.quantity && "Minimum 1 quantity Is Required"}
//                                 />
//                             </Grid>

//                         </Grid> */}

//             <Grid
//               item
//               lg={12}
//               mt={4}
//               display={"flex"}
//               justifyContent={"space-between"}
//               flexDirection={"row"}
//             >
//               <Grid item lg={3}>
//                 <InputLabel sx={{ p: 1, ml: 3 }} htmlFor="depreciationRate">
//                   Depreciation Rate:
//                 </InputLabel>
//               </Grid>

//               <Grid item lg={3}>
//                 <TextField
//                   sx={{ width: "50%", ml: 7 }}
//                   {...register("depreciationRate")}
//                   label="%"
//                   size="small"
//                   error={errors.description}
//                   helperText={errors.description && "Current Depreciation Rate"}
//                 />
//               </Grid>

//               <Grid item lg={3}>
//                 <InputLabel sx={{ p: 1, ml: 3 }} htmlFor="depreciationYear">
//                   Depreciation Year:
//                 </InputLabel>
//               </Grid>
//               <Grid item lg={3}>
//                 <TextField
//                   sx={{ width: "50%", ml: 5 }}
//                   {...register("depreciationYear")}
//                   label="Year"
//                   size="small"
//                   error={errors.description}
//                   helperText={errors.description && "Enter Usefull Life Year"}
//                 />
//               </Grid>
//             </Grid>

//             <Grid item lg={12} p={2} mt={2} textAlign={"center"}>
//               <Button type="submit" variant="contained" color="primary">
//                 Add Product
//               </Button>
//             </Grid>
//           </form>
//         </Grid>
//       </Grid>
//     </Box>
//   );
// }
import {
    Grid, Typography, TextField, InputLabel,
    Select, MenuItem, Button, Dialog, DialogTitle, DialogContent, DialogContentText, DialogActions, Container,
} from "@mui/material";
import axios from "axios";
import * as React from "react";
import { useState } from "react";
import { useForm } from "react-hook-form";
import * as Yup from "yup";
import { yupResolver } from "@hookform/resolvers/yup";




export default function InventoryAddForm() {

    const schema = Yup.object().shape(
        {
            productName: Yup.string().typeError("Name is must").required("Product Name is required"),
            description: Yup.string().required("Description is required"),
            depreciationRate: Yup.number().typeError("Enter Valid Rate").positive().required("Depreciation Rate is required").min(0, "Depreciation Rate must be greater than or equal to 0"),
            depreciationYear: Yup.number().typeError("Enter Valid Year").required().min(new Date().getFullYear(), "Depreciation Year must Current Year or Later")
        }
    )


    const [categories, setCategories] = useState([
        {
            categoryId: "A",
            categoryName: "Laptop",
            specifications: [
                { name: "ram", label: "RAM" },
                { name: "size", label: "Size" },
                { name: "processor", label: "Processor" },
                { name: "graphicsCard", label: "Graphics Card" },
                { name: "brand", label: "Brand" },


            ],
        },
        {
            categoryId: "B",
            categoryName: "Furniture",
            specifications: [
                { name: "chairType", label: "Chair Type" },
                { name: "company", label: "Company" },
                { name: "height", label: "Height" },
            ],
        },
        {
            categoryId: "C",
            categoryName: "Projector",
            specifications: [
                { name: "hdr", label: "HDR" },
                { name: "zoom", label: "Zoom" },
                { name: "resolution", label: "Resolution" },
                { name: "port", label: "Port" },

            ],
        },
    ]);

    const { register: register1, handleSubmit: handleSubmit1, watch, formState: { errors } } = useForm({
        resolver: yupResolver(schema)
    });
    const {
        register: register2,
        handleSubmit: handleSubmit2,
    } = useForm();
    const selectedCategory = watch("category");
    const [isOpen, setisOpen] = useState(false);
    const [open, setOpen] = useState(false);
    const [file, setFile] = useState(null);


    const handleOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
        setFile(null);
    };

    const handleFileChange = (e) => {
        setFile(e.target.files[0]);
    };

    const handleUpload = () => {
        const formData = new FormData();
        formData.append('file', file);

        axios.post('https://0be5-49-207-182-199.ngrok-free.app/upload', formData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        })
            .then(response => {
                console.log('Upload successful-------', response.data);
            })
            .catch(error => {
                console.error('Error uploading file:', error);
            });
    };

    const handleAddCategory = (data) => {
        const { newCategoryId, newCategoryName, specification1, specification2 } = data;

        if (newCategoryId && newCategoryName) {
            const newCategory = {
                categoryId: newCategoryId,
                categoryName: newCategoryName,
                specifications: [
                    { name: "specification1", label: "Specification 1", value: specification1 },
                    { name: "specification2", label: "Specification 2", value: specification2 },

                ],
            };

            const updatedCategories = [...categories, newCategory];
            setCategories(updatedCategories);
            setisOpen(false);
        } else {
            console.log("Category ID and Name are required.");
        }
    };

    const onSubmit = (data) => {
        alert(JSON.stringify(data));
        console.log(data);
    };

    return (
        <Container  >

            {/* main container */}
            <Grid container>

                {/* heading item */}
                <Grid item lg={12} md={12} sm={12} xs={12} mt={3} >
                    <Typography variant={"h5"}  >  Inventory Add Form  </Typography>
                </Grid>

                {/* fileupload item */}
                <Grid item mt={3} lg={12} md={12} sm={12} xs={12} display={'flex'} columnGap={2} justifyContent={'end'}>
                    <Button variant="contained" color="primary" >  Download Template  </Button>
                    <Button variant="contained" color="primary" onClick={handleOpen}>  Upload Template </Button>

                    <Dialog open={open} onClose={handleClose}>
                        <DialogTitle>Upload a File</DialogTitle>
                        <DialogContent>
                            <DialogContentText>
                                Please select a file to upload.
                            </DialogContentText>
                            <TextField
                                type="file"
                                accept=".xlsx"
                                onChange={handleFileChange}
                            />
                        </DialogContent>
                        <DialogActions>
                            <Button onClick={handleClose} color="primary">
                                Cancel
                            </Button>
                            <Button
                                onClick={handleUpload}
                                color="primary"
                                disabled={!file}
                            >
                                Upload
                            </Button>
                        </DialogActions>
                    </Dialog>
                </Grid>
                {/* form item */}
                <Grid item lg={12}   >
                    <form key={1} onSubmit={handleSubmit1(onSubmit)} >

                        <Grid container mt={3} display={'flex'} flexDirection={'row'} justifyContent={'space-between'}>
                            <Grid item lg={4} md={4} sm={4} xs={6}    >
                                <InputLabel sx={{ pt: 1 }} htmlFor="productName">Name Of Asset:</InputLabel>
                            </Grid>
                            <Grid item lg={8} md={8} sm={8} xs={6}>
                                <TextField fullWidth  {...register1("productName")} label="Product Name" size="small" error={errors.productName} helperText={errors.productName?.message} />
                            </Grid>
                        </Grid>

                        <Grid container mt={3} display={'flex'} flexDirection={'row'} justifyContent={'space-between'}>
                            <Grid item lg={4} md={4} sm={4} xs={6}>
                                <InputLabel sx={{ pt: 1 }} htmlFor="description">Description:</InputLabel>
                            </Grid>
                            <Grid item lg={8} md={8} sm={8} xs={6}>
                                <TextField fullWidth  {...register1("description")} label="Description" size="small" error={errors.description} helperText={errors.description?.message} />
                            </Grid>
                        </Grid>
                        <Grid container mt={3} display={'flex'} flexDirection={'row'} justifyContent={'space-between'}>
                            <Grid item lg={4}  >
                                <InputLabel sx={{ pt: 1 }} htmlFor="category">Category Type:</InputLabel>
                            </Grid>
                            <Grid item lg={4}>
                                <Select
                                    size="small"
                                    defaultValue=" "
                                    fullWidth
                                    {...register1("category")}
                                    error={errors.category}>

                                    <MenuItem value=" ">---Select---</MenuItem>
                                    {categories.map((category) => (

                                        <MenuItem key={category.categoryId} value={category.categoryId}>
                                            {category.categoryName}
                                        </MenuItem>
                                    ))}
                                </Select>
                            </Grid>

                            <Grid item lg={4} display={'flex'} flexDirection={'row'} justifyContent={'end'}>
                                <Button variant="contained" color="primary" onClick={() => setisOpen(true)}>
                                    Add Category
                                </Button>
                                <Dialog open={isOpen} onClose={() => setisOpen(false)}>
                                    <DialogTitle>Add Category</DialogTitle>
                                    <DialogContent >
                                        <form key={2} onSubmit={handleSubmit2(handleAddCategory)}>
                                            <TextField
                                                fullWidth
                                                {...register2("newCategoryId")}
                                                placeholder="Category ID"
                                                size="small"

                                            />
                                            <TextField
                                                sx={{ mt: 2 }}
                                                fullWidth
                                                {...register2("newCategoryName")}
                                                placeholder="Category Name"
                                                size="small"


                                            />

                                            <TextField
                                                {...register2("specification1")}
                                                size="small"
                                                label="Specification 1"
                                            />
                                            <TextField
                                                {...register2("specification2")}
                                                size="small"
                                                label="Specification 2"
                                            />


                                            <DialogActions>
                                                <Button onClick={() => setisOpen(false)} color="primary">
                                                    Cancel
                                                </Button>
                                                <Button type="submit" color="primary">
                                                    Add
                                                </Button>
                                            </DialogActions>
                                        </form>
                                    </DialogContent>
                                </Dialog>
                            </Grid>

                            <Grid container mt={3} display={"flex"} flexDirection={'row'} justifyContent={"space-between"}>
                                {selectedCategory && selectedCategory !== " " ? (
                                    <>
                                        <Grid item lg={4} >
                                            <InputLabel  >Specifications:</InputLabel>
                                        </Grid>


                                        <Grid item lg={8}  >

                                            <Grid container rowGap={1} columnGap={1}>
                                                {categories.find((category) => category.categoryId === selectedCategory)?.specifications.map((specification) =>
                                                (


                                                    <TextField

                                                        {...register1(`specifications.${specification.name}`)}
                                                        size="small"
                                                        key={specification.name}
                                                        label={specification.label}

                                                    />


                                                ))}
                                            </Grid>
                                        </Grid>

                                    </>
                                ) : null}
                            </Grid>

                        </Grid>
                        <Grid container mt={3} display={'flex'} flexDirection={'row'} justifyContent={'space-between'}>
                            <Grid item lg={4}  >
                                <InputLabel sx={{ pt: 1 }} htmlFor="depreciationRate">Depreciation Rate:</InputLabel>
                            </Grid>

                            <Grid item lg={3} >
                                <TextField

                                    {...register1("depreciationRate")}
                                    label="%"
                                    size="small"
                                    error={errors.depreciationRate}
                                    helperText={errors.depreciationRate?.message}
                                />
                            </Grid>
                            <Grid item lg={2.5}>
                                <InputLabel sx={{ p: 1 }} htmlFor="depreciationYear">Life Year:</InputLabel>
                            </Grid>
                            <Grid item lg={2.5} >
                                <TextField
                                    {...register1("depreciationYear")}
                                    label="Year"
                                    size="small"

                                    error={errors.depreciationYear}
                                    helperText={errors.depreciationYear?.message}
                                />
                            </Grid>
                        </Grid>
                        <Grid container mt={3} display={'flex'} flexDirection={'row'} justifyContent={'space-between'}>
                            <Grid item lg={4}  >
                                <InputLabel sx={{ pt: 1 }} htmlFor="startDate">Start Date:</InputLabel>
                            </Grid>

                            <Grid item lg={3}  >
                                <TextField

                                    {...register1("startDate")}
                                    type="date"
                                    size="small"

                                    error={errors.depreciationRate}
                                    helperText={errors.depreciationRate?.message}
                                />
                            </Grid>

                            <Grid item lg={2.5} >
                                <InputLabel sx={{ p: 1 }} htmlFor="endDate">End Date:</InputLabel>
                            </Grid>
                            <Grid item lg={2.5} >
                                <TextField
                                    {...register1("endDate")}
                                    type="date"
                                    size="small"

                                    error={errors.depreciationYear}
                                    helperText={errors.depreciationYear?.message}
                                />
                            </Grid>
                        </Grid>
                        <Grid container mt={4} justifyContent={'center'}>
                            <Button type="submit" variant="contained" color="primary">
                                Add Product
                            </Button>
                        </Grid>
                    </form>

                </Grid>

            </Grid >

        </Container >


    );
}