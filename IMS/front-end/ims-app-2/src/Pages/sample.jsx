import {
    Box, Grid, Typography, TextField, InputLabel,
    Select, MenuItem, Button,
} from "@mui/material";

import * as React from "react";
import { useState } from "react";
import { useForm } from "react-hook-form";


export default function InventoryAddForm() {
    const [isDialogOpen, setIsDialogOpen] = useState(false);

    const [categories, setCategories] = useState([
        { value: " ", label: "---Select---"}, 
        { value: "A", label: "Category A" },
        { value: "B", label: "Laptop" },
        { value: "C", label: "Furniture" },
        { value: "D", label: "Category D" },
    ]);

    const categoryConfigurations = {
        B: {
            fields: [
                { name: "ram", label: "RAM" },
                { name: "size", label: "SIZE" },
                { name: "processor", label: "Processor" },
                { name: "graphicsCard", label: "Graphics Card" },
            ],
        },
     
        
    };

    const { register, handleSubmit, watch, formState: { errors } } = useForm({

    });
    const handleOpenDialog = () => {
        setIsDialogOpen(true);
    };

    const handleCloseDialog = () => {
        setIsDialogOpen(false);
    };
    const onSubmit = (data) => {
        console.log(data);
    };
    const selectedCategory = watch("category");
    return (
        <Box>
            <Grid container>
                <Grid item xs={12} mt={2} p={2} textAlign="center">
                    <Typography >
                        Product Adding Form
                    </Typography>
                </Grid>


                <Grid item mt={2} lg={8} p={2}  >
                    <form onSubmit={handleSubmit(onSubmit)} >

                        <Grid item lg={10} display={"flex"} justifyContent={"space-evenly"} flexDirection={"row"}>
                            <Grid item lg={2}>
                                <InputLabel sx={{ p: 1, mt: 1 }} htmlFor="productName">Product Name:</InputLabel>
                            </Grid>
                            <Grid item lg={8}>
                                <TextField sx={{ ml: 5, mt: 1 }}
                                    {...register("productName",)}
                                    label="Product Name"
                                    size="small"
                                    error={errors.productName}
                                    helperText={errors.productName && "name is required"}
                                />
                            </Grid>
                        </Grid>



                        <Grid item lg={10} mt={2} display={"flex"} justifyContent={"space-evenly"} flexDirection={"row"}>
                            <Grid item lg={2}>
                                <InputLabel sx={{ p: 1, mt: 1 }} htmlFor="description">Description:</InputLabel>
                            </Grid>
                            <Grid item lg={8}>
                                <TextField sx={{ ml: 5, mt: 1 }}
                                    {...register("description",)}
                                    label="Description"
                                    size="small"
                                    error={errors.description}
                                    helperText={errors.description && "Enter must"}
                                />
                            </Grid>

                        </Grid>

                        <Grid item lg={10} mt={2} display={"flex"} justifyContent={"space-evenly"} flexDirection={"row"}>
                            <Grid item lg={2}>
                                <InputLabel sx={{ p: 1, mt: 1 }} htmlFor="category">Category Type:</InputLabel>
                            </Grid>
                            <Grid item lg={8} >
                                <Select size="small" sx={{ ml: 5, mt: 1 }}
                                    defaultValue=" "
                                    {...register("category")}
                                    error={errors.category}>

                                    {categories.map((option) => (
                                        <MenuItem key={option.value} value={option.value}>
                                            {option.label}
                                        </MenuItem>
                                    ))}
                                    <MenuItem onClick={handleOpenDialog}>New Category</MenuItem>

                                </Select>
                            </Grid>




                        </Grid>
                        <Grid item lg={10} mt={2} display={"flex"} flexDirection={"row"} justifyContent={"space-evenly"}>
                            {selectedCategory === "B" && (
                                <>
                                    <Grid item lg={2} color={"green"}>
                                        <InputLabel sx={{ p: 1, mt: 1 }} htmlFor="specification">Specifications:</InputLabel>
                                    </Grid>


                                    <Grid item lg={8} color={"yellow"} display={"flex"} flexDirection={'row'} flexWrap={"wrap"} justifyContent={"space-evenly"}>
                                        <Grid item ml={5} color={"red"} >

                                            <TextField sx={{ mt: 1 }} size="small"
                                                {...register("ram",)}
                                                label="RAM"

                                                error={errors.specification}
                                                helperText={errors.specification && "Enter Valid Specs"}
                                            />
                                            <TextField sx={{ mt: 1 }} size="small"
                                                {...register("size",)}
                                                label="SIZE"

                                                error={errors.specification}
                                                helperText={errors.specification && "Enter Valid Specs"}
                                            />


                                            <TextField
                                                sx={{ mt: 1 }} size="small"
                                                {...register("processor",)}
                                                label="Processor"

                                                error={errors.processor}
                                                helperText={errors.processor && "Enter Valid Processor"}
                                            />

                                            <TextField
                                                sx={{ mt: 1 }} size="small"
                                                {...register("graphicsCard",)}
                                                label="Graphics Card"

                                                error={errors.graphicsCard}
                                                helperText={errors.graphicsCard && "Enter Valid Graphics Card"}
                                            />
                                        </Grid>
                                    </Grid>
                                </>
                            )}


                        </Grid>


                        <Grid item lg={10} mt={2} display={"flex"} flexDirection={"row"} justifyContent={"space-evenly"} >

                            <Grid item lg={2} mt={2}>
                                <InputLabel sx={{ p: 1, mt: 1 }} htmlFor="count">Count:</InputLabel>
                            </Grid>
                            <Grid item lg={8}>
                                <TextField sx={{ ml: 5, mt: 2 }}
                                    {...register("count",)}
                                    label="Qty"
                                    type="number"
                                    size="small"
                                    error={errors.count}
                                    helperText={errors.count && "Minimum 1 Count Is Required"}
                                />
                            </Grid>

                        </Grid>


                        <Grid item lg={10} mt={2} display={"flex"} justifyContent={"space-evenly"} flexDirection={"row"}>

                            <Grid item lg={3} mt={2} display={"flex"} justifyContent={"space-evenly"} >
                                <InputLabel sx={{ p: 1, mt: 1 }} htmlFor="depreciationRate">Depreciation Rate:</InputLabel>
                            </Grid>

                            <Grid item lg={2}  >
                                <TextField
                                    {...register("depreciationRate",)}
                                    label="%"
                                    sx={{ p: 1, mt: 2 }}
                                    size="small"
                                    error={errors.description}
                                    helperText={errors.description && "Current Depreciation Rate"}
                                />
                            </Grid>

                            <Grid item mt={2} >
                                <InputLabel sx={{ p: 1, mt: 1 }} htmlFor="depreciationYear">Depreciation Year:</InputLabel>
                            </Grid>
                            <Grid item lg={3} mt={1}>
                                <TextField sx={{ p: 1, mt: 1 }}
                                    {...register("depreciationYear",)}
                                    label="Year"
                                    size="small"
                                    error={errors.description}
                                    helperText={errors.description && "Enter Usefull Life Year"}
                                />
                            </Grid>
                        </Grid>



                        <Grid item lg={11} p={1} mt={2} textAlign={"center"}>
                            <Button type="submit" variant="contained" color="primary">
                                Add Product
                            </Button>
                        </Grid>

                    </form>
                </Grid>
            </Grid >
        </Box >
    );
}