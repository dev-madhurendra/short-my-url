import { Button } from "@mui/material";
import { ButtonPropsInterface } from "../../../utils/interfaces";

const MuiButton = ({ ...buttonProps }: ButtonPropsInterface) =>
    <Button {...buttonProps} disableElevation disableRipple />;

export default MuiButton;
