import axios from 'axios';

export async function ApiRequest(path, method , data, isFormData = false) {
  try {
    const response = await axios({
      url: `${path}`,
      method: method,
      headers: {
        'Content-Type': isFormData
          ?  'multipart/form-data'
          : 'application/json',
      },
      data: data ? data : undefined,
    });
    console.log("//////", response);
    const response_1 = response?.data?.body;
    console.log("//////", response_1);
    return response_1;
  } catch (error) {
    console.log("axiosError", error.response, error);
    return error?.response?.message;
  }
}

